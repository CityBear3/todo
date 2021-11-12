package com.project.todo.api.controller

import com.project.todo.domain.entity.TodoEntity
import com.project.todo.api.request.CreateTodoRequest
import com.project.todo.api.request.UpdateTodoRequest
import com.project.todo.application.service.TodoApplicationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class TodoController(private val todoApplicationService: TodoApplicationService) {
    @PostMapping("/new")
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<String> {
        return todoApplicationService.createTodo(
            TodoEntity(
                title = createTodoRequest.title,
                description = createTodoRequest.description,
                done = createTodoRequest.done,
                userId = createTodoRequest.userId
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
}