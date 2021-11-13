package com.project.todo.application.service

import com.project.todo.api.response.GetTodoResponse
import com.project.todo.application.logic.UserCheckLogic
import com.project.todo.domain.entity.TodoEntity
import com.project.todo.domain.model.TodoRecord
import com.project.todo.domain.repository.TodoRepository
import com.project.todo.utils.factory.UserInfoFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TodoApplicationService(
    private val todoRepository: TodoRepository,
    private val userCheckLogic: UserCheckLogic,
    private val userInfoFactory: UserInfoFactory
) {
    fun createTodo(todoEntity: TodoEntity): Pair<String, HttpStatus> {
        val record = todoEntity.createRecord()
        if (!userCheckLogic.checkUser(record.userId!!)) {
            return Pair("Auth Error", HttpStatus.FORBIDDEN)
        }

        kotlin.runCatching {
            todoRepository.create(record)
        }.fold(
            onSuccess = { return Pair("create todo is successful", HttpStatus.OK) },
            onFailure = { return Pair("create todo is failed", HttpStatus.INTERNAL_SERVER_ERROR) }
        )
    }

    fun updateTodo(todoEntity: TodoEntity): Pair<String, HttpStatus> {
        val record = todoEntity.updateRecord()
        if (!userCheckLogic.checkUserByTodoId(record.id!!)) {
            return Pair("Auth Error", HttpStatus.FORBIDDEN)
        }

        kotlin.runCatching {
            todoRepository.update(record)
        }.fold(
            onSuccess = { return Pair("update todo is successful", HttpStatus.OK) },
            onFailure = { return Pair("update todo is failed", HttpStatus.INTERNAL_SERVER_ERROR) }
        )
    }

    fun getTodos(): Pair<GetTodoResponse, HttpStatus> {
        var todos = listOf<TodoRecord>()
        kotlin.runCatching {
            todos = todoRepository.selectByUid(userInfoFactory.getUserInfo().id)
        }.fold(
            onSuccess = { return Pair(GetTodoResponse(message = "succeeded", todos = todos), HttpStatus.OK) },
            onFailure = {
                return Pair(
                    GetTodoResponse(message = "failed", todos = todos),
                    HttpStatus.INTERNAL_SERVER_ERROR
                )
            }
        )
    }
}