package com.project.todo.domain.repository

import com.project.todo.domain.model.TodoRecord

interface TodoRepository {
    fun create(todoRecord: TodoRecord)

    fun select(todoId: Int): TodoRecord?

    fun selectByUid(uid: Int): List<TodoRecord>

    fun update(todoRecord: TodoRecord)
}