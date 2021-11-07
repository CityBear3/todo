package com.project.todo.service

import com.project.todo.entity.TodoEntity
import com.project.todo.repository.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoRepository) {
    fun createTodo(todoEntity: TodoEntity): ResponseEntity<String> {
        kotlin.runCatching {
            todoRepository.create(todoEntity.createRecord())
        }.fold(
            onSuccess = { return ResponseEntity("create todo is successful", HttpStatus.OK) },
            onFailure = { return ResponseEntity("create todo is failed", HttpStatus.INTERNAL_SERVER_ERROR) }
        )
    }

    fun updateTodo(id: Int, todoEntity: TodoEntity): ResponseEntity<String> {
        val record = todoEntity.updateRecord()
        record.id = id
        kotlin.runCatching {
            todoRepository.update(record)
        }.fold(
            onSuccess = { return ResponseEntity("update todo is successful", HttpStatus.OK) },
            onFailure = { return ResponseEntity("update todo is failed", HttpStatus.INTERNAL_SERVER_ERROR) }
        )
    }
}