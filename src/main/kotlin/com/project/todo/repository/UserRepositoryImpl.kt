package com.project.todo.repository

import com.project.todo.mapper.UserDynamicSqlSupport.User.email
import com.project.todo.mapper.UserMapper
import com.project.todo.mapper.insert
import com.project.todo.mapper.insertSelective
import com.project.todo.mapper.selectOne
import com.project.todo.model.UserRecord
import com.project.todo.utils.factory.CreateSessionFactory
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
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

    override fun selectByEmail(userRecord: UserRecord): UserRecord? {
        val user: UserRecord?
        createSessionFactory.newFactory()
            .openSession()
            .use {
                session ->
                val mapper = session.getMapper(UserMapper::class.java)
                user = mapper.selectOne {
                    where(email, isEqualTo(userRecord.email!!))
                }
            }
        return user
    }
}