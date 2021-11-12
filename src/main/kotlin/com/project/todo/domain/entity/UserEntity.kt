package com.project.todo.domain.entity

import com.project.todo.domain.model.UserRecord
import com.project.todo.domain.model.enum.RoleType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

class UserEntity(
    private val userName: String? = null,
    private val email: String? = null,
    private val password: String? = null,
    private val role: RoleType? = null
) {
    fun checkEmail(): Boolean {
        return email!!.matches(
            Regex("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}\$")
        )
    }

    fun checkPassword(): Boolean {
        return password!!.matches(Regex("^(?=.*[A-Z])(?=.*[?/-])[a-zA-z0-9?/-]{8,24}$"))
    }

    fun createRecode(): UserRecord {
        return UserRecord(
            username = userName,
            email = email,
            password = BCryptPasswordEncoder().encode(password),
            role = role,
            createTime = Date()
        )
    }
}
