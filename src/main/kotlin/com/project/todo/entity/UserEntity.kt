package com.project.todo.entity

import com.project.todo.model.UserRecord
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

class UserEntity(
    private val userName: String,
    private val email: String,
    private val password: String,
    private val isAdmin: Boolean
) {
    fun checkEmail(): Boolean {
        return email.matches(
            Regex("^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}\$")
        )
    }

    fun checkPassword(): Boolean {
        return password.matches(Regex("^(?=.*[A-Z])(?=.*[?/-])[a-zA-z0-9?/-]{8,24}$"))
    }

    fun createRecode(): UserRecord {
        val userRecord = UserRecord(
            username = userName,
            email = email,
            password = BCryptPasswordEncoder().encode(password),
            isAdmin = if (isAdmin) {
                1.toByte()
            } else {
                0.toByte()
            },
            createTime = Date()
        )
        return userRecord
    }
}
