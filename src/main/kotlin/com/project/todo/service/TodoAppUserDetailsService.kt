package com.project.todo.service

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

data class TodoAppUserDetails(val id: Int, val email: String, val pass: String, val roleType: RoleType) :
    UserDetails {

    constructor(user: UserRecord): this(user.id!!, user.email!!, user.password!!, user.role!!)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.roleType.toString())
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}