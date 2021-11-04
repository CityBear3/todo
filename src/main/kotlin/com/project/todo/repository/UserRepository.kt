package com.project.todo.repository

import com.project.todo.model.UserRecord

interface UserRepository {
    fun create(userRecord: UserRecord)
}