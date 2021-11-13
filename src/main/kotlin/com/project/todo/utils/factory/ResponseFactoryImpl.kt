package com.project.todo.utils.factory

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class ResponseFactoryImpl : ResponseFactory {
    override fun <T> returnFactory(arg: T, status: HttpStatus): ResponseEntity<T> {
        return ResponseEntity(
            arg,
            status
        )
    }
}