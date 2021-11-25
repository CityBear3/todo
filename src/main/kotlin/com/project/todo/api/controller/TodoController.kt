package com.project.todo.api.controller

import com.project.todo.api.request.CreateTodoRequest
import com.project.todo.api.request.UpdateTodoRequest
import com.project.todo.api.response.GetTodoResponse
import com.project.todo.application.service.TodoApplicationService
import com.project.todo.domain.entity.TodoEntity
import com.project.todo.utils.factory.ResponseFactory
import com.project.todo.utils.factory.UserInfoFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoApplicationService: TodoApplicationService,
    private val userInfoFactory: UserInfoFactory,
    private val responseFactory: ResponseFactory
) {
    @PostMapping
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<String> {
        val result = todoApplicationService.createTodo(
            TodoEntity(
                title = createTodoRequest.title,
                description = createTodoRequest.description,
                done = false,
                userId = userInfoFactory.getUserInfo().id
            )
        )
        return responseFactory.returnFactory(result.first, result.second)
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable("todoId") todoId: Int,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<String> {
        val result = todoApplicationService.updateTodo(
            TodoEntity(
                id = todoId,
                title = updateTodoRequest.title,
                description = updateTodoRequest.description,
                done = updateTodoRequest.done
            )
        )
        return responseFactory.returnFactory(result.first, result.second)
    }

    @GetMapping
    fun getTodos(): ResponseEntity<GetTodoResponse> {
        val result = todoApplicationService.getTodos()
        return responseFactory.returnFactory(result.first, result.second)
    }
}
