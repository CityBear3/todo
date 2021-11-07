package com.project.todo.api.controller

import com.project.todo.entity.UserEntity
import com.project.todo.entity.request.CreateUserRequest
import com.project.todo.entity.response.CreateUserResponse
import com.project.todo.model.enum.RoleType
import com.project.todo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(val userService: UserService) {
    @PostMapping("/signup")
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): ResponseEntity<CreateUserResponse> {
        return userService.createUser(
            UserEntity(
                userName = createUserRequest.userName,
                email = createUserRequest.email,
                password = createUserRequest.password,
                role = RoleType.USER
            )
        )
    }
}