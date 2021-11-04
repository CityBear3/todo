package com.project.todo.repository

import com.project.todo.mapper.UserMapper
import com.project.todo.mapper.insert
import com.project.todo.model.UserRecord
import com.project.todo.utils.factory.CreateSessionFactory
import org.springframework.stereotype.Component

@Component
class UserRepositoryImpl(private val createSessionFactory: CreateSessionFactory): UserRepository {
    override fun create(userRecord: UserRecord) {
        createSessionFactory.newFactory()
            .openSession()
            .use {
                    session ->
                val mapper = session.getMapper(UserMapper::class.java)
                mapper.insert(userRecord)
                session.commit()
            }
    }
}