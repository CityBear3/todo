package com.project.todo.service

import com.project.todo.entity.UserEntity
import com.project.todo.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun createUser(userEntity: UserEntity): ResponseEntity<String> {
        if (!userEntity.checkEmail()) {
            return ResponseEntity("Please check your email address enough rule", HttpStatus.BAD_REQUEST)
        }

        if (!userEntity.checkPassword()) {
            return ResponseEntity("Please check your password enough rule", HttpStatus.BAD_REQUEST)
        }

        kotlin.runCatching {
            userRepository.create(userEntity.createRecode())
        }.fold(
            onSuccess = { return ResponseEntity("User create was success", HttpStatus.OK) },
            onFailure = { return ResponseEntity("User create was failed", HttpStatus.INTERNAL_SERVER_ERROR) }
        )
    }
}