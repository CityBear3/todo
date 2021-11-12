package com.project.todo.application.service

import com.project.todo.api.response.CreateUserResponse
import com.project.todo.domain.entity.UserEntity
import com.project.todo.domain.model.UserRecord
import com.project.todo.domain.repository.UserRepository
import com.project.todo.domain.service.UserDomainService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserApplicationService(
    private val userRepository: UserRepository,
    private val userDomainService: UserDomainService
) {
    fun createUser(userEntity: UserEntity): ResponseEntity<CreateUserResponse> {
        var userRecord = UserRecord()
        if (!userEntity.checkEmail()) {
            return ResponseEntity(
                CreateUserResponse(
                    uid = -1,
                    message = "Please check your email address enough rule"
                ),
                HttpStatus.BAD_REQUEST
            )
        }

        if (userDomainService.exists(userEntity)) {
            return ResponseEntity(
                CreateUserResponse(
                    uid = -1,
                    message = "This account has been already existed"
                ),
                HttpStatus.BAD_REQUEST
            )
        }

        if (!userEntity.checkPassword()) {
            return ResponseEntity(
                CreateUserResponse(
                    uid = -1,
                    message = "Please check your password enough rule"
                ),
                HttpStatus.BAD_REQUEST
            )
        }

        kotlin.runCatching {
            userRepository.create(userEntity.createRecode())
            userRecord = userRepository.selectByEmail(userEntity.createRecode())!!
        }.fold(
            onSuccess = {
                return ResponseEntity(
                    CreateUserResponse(
                        uid = userRecord.id!!,
                        message = "User create was success"
                    ),
                    HttpStatus.OK
                )
            },
            onFailure = {
                return ResponseEntity(
                    CreateUserResponse(
                        uid = -1,
                        message = "User create was failed"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
                )
            }
        )
    }
}