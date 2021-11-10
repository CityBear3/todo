package com.project.todo.logic

import com.project.todo.repository.TodoRepository
import com.project.todo.utils.factory.UserInfoFactory
import org.springframework.stereotype.Component

@Component
class UserCheckLogic(private val todoRepository: TodoRepository, private val userInfoFactory: UserInfoFactory) {
    fun checkUser(uid: Int): Boolean {
        return uid == userInfoFactory.getUserInfo().id
    }

    fun checkUserByTodoId(todoId: Int): Boolean {
        val user = todoRepository.select(todoId)
        return user != null && userInfoFactory.getUserInfo().id == user.userId
    }
}