package com.project.todo.application.service

import com.project.todo.application.details.TodoAppUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class TodoAppUserDetailsService(private val authenticationService: AuthenticationService): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = authenticationService.findUser(username!!)
        return user?.let { TodoAppUserDetails(user) }
    }
}
