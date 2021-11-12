package com.project.todo.domain.entity

import com.project.todo.domain.model.TodoRecord
import java.util.*

class TodoEntity(
    private val id: Int? = null,
    private val title: String? = null,
    private val description: String? = null,
    private val done: Boolean? = null,
    private val userId: Int? = null,
) {
    fun createRecord(): TodoRecord {
        return TodoRecord(
            title = title,
            description = description,
            done = if (done!!) {
                1.toByte()
            } else {
                0.toByte()
            },
            userId = userId,
            createTime = Date(),
            updateTime = Date(),
        )
    }

    fun updateRecord(): TodoRecord {
        return TodoRecord(
            id = id,
            title = title,
            description = description,
            done = if (done != null && done) {
                1.toByte()
            } else {
                0.toByte()
            },
            userId = userId,
            createTime = null,
            updateTime = Date(),
        )
    }
}