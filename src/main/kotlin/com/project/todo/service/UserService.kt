package com.project.todo.service

import com.project.todo.entity.UserEntity
import com.project.todo.entity.response.UserCreateResponse
import com.project.todo.model.UserRecord
import com.project.todo.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun createUser(userEntity: UserEntity): ResponseEntity<UserCreateResponse> {
        var userRecord = UserRecord()
        if (!userEntity.checkEmail()) {
            return ResponseEntity(
                UserCreateResponse(
                    uid = -1,
                    message = "Please check your email address enough rule"
                ),
                HttpStatus.BAD_REQUEST
            )
        }

        if (!userEntity.checkPassword()) {
            return ResponseEntity(
                UserCreateResponse(
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
            onSuccess = { return ResponseEntity(
                UserCreateResponse(
                    uid = userRecord.id!!,
                    message = "User create was success"
                ),
                HttpStatus.OK
            ) },
            onFailure = {
                return ResponseEntity(
                    UserCreateResponse(
                        uid = -1,
                        message = "User create was failed"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
                )
            }
        )
    }
}