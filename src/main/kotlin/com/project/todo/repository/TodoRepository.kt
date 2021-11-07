package com.project.todo.repository

import com.project.todo.model.TodoRecord

interface TodoRepository {
    fun create(todoRecord: TodoRecord)

    fun selectByUid(uid: Int): List<TodoRecord>

    fun update(todoRecord: TodoRecord)
}