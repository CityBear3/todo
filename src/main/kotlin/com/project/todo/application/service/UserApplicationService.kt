package com.project.todo.application.service

import com.project.todo.domain.entity.UserEntity
import com.project.todo.domain.repository.UserRepository
import com.project.todo.domain.service.UserDomainService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserApplicationService(
    private val userRepository: UserRepository,
    private val userDomainService: UserDomainService
) {
    fun createUser(userEntity: UserEntity): Pair<String, HttpStatus> {
        if (!userEntity.checkEmail()) {
            return Pair("Please check your email address enough rule", HttpStatus.BAD_REQUEST)
        }

        if (userDomainService.exists(userEntity)) {
            return Pair("This account has been already existed", HttpStatus.BAD_REQUEST)
        }

        if (!userEntity.checkPassword()) {
            return Pair("Please check your password enough rule", HttpStatus.BAD_REQUEST)
        }

        kotlin.runCatching {
            userRepository.create(userEntity.createRecode())
        }.fold(
            onSuccess = {
                return Pair("User create was success", HttpStatus.OK)
            },
            onFailure = {
                return Pair("User create was failed", HttpStatus.INTERNAL_SERVER_ERROR)
            }
        )
    }
}