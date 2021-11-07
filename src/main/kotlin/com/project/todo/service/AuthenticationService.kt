package com.project.todo.service

import com.project.todo.model.UserRecord
import com.project.todo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val userRepository: UserRepository) {
    fun findUser(email: String): UserRecord? {
        return userRepository.selectByEmail(UserRecord(email = email))
    }
}