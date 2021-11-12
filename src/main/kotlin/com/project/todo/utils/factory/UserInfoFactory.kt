package com.project.todo.utils.factory

import com.project.todo.application.details.TodoAppUserDetails

interface UserInfoFactory {
    fun getUserInfo(): TodoAppUserDetails
}