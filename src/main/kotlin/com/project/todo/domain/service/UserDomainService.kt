package com.project.todo.domain.service

import com.project.todo.domain.entity.UserEntity
import com.project.todo.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserDomainService(private val userRepository: UserRepository) {
    fun exists(userEntity: UserEntity): Boolean {
        return userRepository.selectByEmail(userEntity.createRecode()) != null
    }
}