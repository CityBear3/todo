package com.project.todo.utils.factory

import com.project.todo.entity.details.TodoAppUserDetails

interface UserInfoFactory {
    fun getUserInfo(): TodoAppUserDetails
}