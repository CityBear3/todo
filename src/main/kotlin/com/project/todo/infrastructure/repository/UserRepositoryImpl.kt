package com.project.todo.infrastructure.repository

import com.project.todo.domain.repository.UserRepository
import com.project.todo.infrastructure.mapper.UserDynamicSqlSupport.User.email
import com.project.todo.infrastructure.mapper.UserMapper
import com.project.todo.infrastructure.mapper.insert
import com.project.todo.infrastructure.mapper.selectByPrimaryKey
import com.project.todo.infrastructure.mapper.selectOne
import com.project.todo.domain.model.UserRecord
import com.project.todo.utils.factory.CreateSessionFactory
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
import org.springframework.stereotype.Repository

@Repository
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

    override fun selectById(uid: Int): UserRecord? {
        val user: UserRecord?
        createSessionFactory.newFactory()
            .openSession()
            .use {
                session ->
                val mapper = session.getMapper(UserMapper::class.java)
                user = mapper.selectByPrimaryKey(uid)
            }
        return user
    }
}