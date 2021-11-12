package com.project.todo.domain.repository

import com.project.todo.domain.model.UserRecord

interface UserRepository {
    fun create(userRecord: UserRecord)

    fun selectByEmail(userRecord: UserRecord): UserRecord?

    fun selectById(uid: Int): UserRecord?
}