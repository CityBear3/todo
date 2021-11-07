package com.project.todo.utils.factory

import com.project.todo.entity.details.TodoAppUserDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserInfoFactoryImpl : UserInfoFactory {
    override fun getUserInfo(): TodoAppUserDetails {
        return SecurityContextHolder.getContext().authentication.principal as TodoAppUserDetails
    }
}