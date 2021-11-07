package com.project.todo.entity.request

data class CreateTodoRequest(val title: String, val description: String, val done: Boolean, val userId: Int)
