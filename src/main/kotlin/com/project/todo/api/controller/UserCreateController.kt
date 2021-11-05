package com.project.todo.api.controller

import com.project.todo.entity.UserEntity
import com.project.todo.entity.response.UserCreateResponse
import com.project.todo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserCreateController(val userService: UserService) {
    @PostMapping("/user/creation")
    fun createUser(@RequestBody userEntity: UserEntity): ResponseEntity<UserCreateResponse> {
        return userService.createUser(userEntity)
    }
}