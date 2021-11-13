package com.project.todo.api.controller

import com.project.todo.api.request.CreateTodoRequest
import com.project.todo.api.request.UpdateTodoRequest
import com.project.todo.api.response.GetTodoResponse
import com.project.todo.application.service.TodoApplicationService
import com.project.todo.domain.entity.TodoEntity
import com.project.todo.utils.factory.UserInfoFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class TodoController(
    private val todoApplicationService: TodoApplicationService,
    private val userInfoFactory: UserInfoFactory
) {
    @PostMapping("/new")
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<String> {
        return todoApplicationService.createTodo(
            TodoEntity(
                title = createTodoRequest.title,
                description = createTodoRequest.description,
                done = false,
                userId = userInfoFactory.getUserInfo().id
            )
        )
    }

    @PutMapping("/update/{todoId}")
    fun updateTodo(
        @PathVariable("todoId") todoId: Int,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<String> {
        return todoApplicationService.updateTodo(
            TodoEntity(
                id = todoId,
                title = updateTodoRequest.title,
                description = updateTodoRequest.description,
                done = updateTodoRequest.done
            )
        )
    }

    @GetMapping("/list")
    fun getTodos(): ResponseEntity<GetTodoResponse> {
        return todoApplicationService.getTodos()
    }
}