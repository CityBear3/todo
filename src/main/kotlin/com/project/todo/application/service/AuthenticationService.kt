package com.project.todo.application.service

import com.project.todo.domain.model.UserRecord
import com.project.todo.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val userRepository: UserRepository) {
    fun findUser(email: String): UserRecord? {
        return userRepository.selectByEmail(UserRecord(email = email))
    }
}