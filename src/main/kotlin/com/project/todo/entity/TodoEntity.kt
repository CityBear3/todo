package com.project.todo.entity

import com.project.todo.model.TodoRecord

class TodoEntity(
    private val title: String,
    private val description: String,
    private val done: Boolean,
    private val userId: Int,
) {
    fun createRecode(): TodoRecord {
        return TodoRecord(
            title = title,
            description = description,
            done = if (done) {
                1.toByte()
            } else {
                0.toByte()
            },
            userId = userId
        )
    }
}