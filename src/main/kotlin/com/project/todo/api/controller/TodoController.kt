package com.project.todo.api.controller

import com.project.todo.entity.TodoEntity
import com.project.todo.entity.request.CreateTodoRequest
import com.project.todo.entity.request.UpdateTodoRequest
import com.project.todo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class TodoController(private val todoService: TodoService) {
    @PostMapping("/new")
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<String> {
        return todoService.createTodo(
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
        return todoService.updateTodo(
            todoId, TodoEntity(
                title = updateTodoRequest.title,
                description = updateTodoRequest.description,
                done = updateTodoRequest.done
            )
        )
    }
}