package com.project.todo.utils.factory

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

interface ResponseFactory {
    fun <T> returnFactory(arg: T, status: HttpStatus): ResponseEntity<T>
}