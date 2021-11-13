package com.project.todo.api.response

import com.project.todo.domain.model.TodoRecord

data class GetTodoResponse(val todos: List<TodoRecord>, val message: String)
