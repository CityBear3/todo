package com.project.todo.api.controller

import com.project.todo.api.request.CreateUserRequest
import com.project.todo.application.service.UserApplicationService
import com.project.todo.domain.entity.UserEntity
import com.project.todo.domain.model.enum.RoleType
import com.project.todo.utils.factory.ResponseFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userApplicationService: UserApplicationService,
    private val responseFactory: ResponseFactory
) {
    @PostMapping("/signup")
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): ResponseEntity<String> {
        val result = userApplicationService.createUser(
            UserEntity(
                userName = createUserRequest.userName,
                email = createUserRequest.email,
                password = createUserRequest.password,
                role = RoleType.USER
            )
        )

        return responseFactory.returnFactory(result.first, result.second)
    }
}