package com.project.todo.service

import com.project.todo.entity.details.TodoAppUserDetails
import com.project.todo.model.UserRecord
import com.project.todo.model.enum.RoleType
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class TodoAppUserDetailsService(private val authenticationService: AuthenticationService): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = authenticationService.findUser(username!!)
        return user?.let { TodoAppUserDetails(user) }
    }
}
