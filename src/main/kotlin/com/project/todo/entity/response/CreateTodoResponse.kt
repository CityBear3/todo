package com.project.todo.entity.response

import com.project.todo.model.TodoRecord

data class CreateTodoResponse(val todos: List<TodoRecord>, val message: String)
