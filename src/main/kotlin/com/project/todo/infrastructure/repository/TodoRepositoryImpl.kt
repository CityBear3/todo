package com.project.todo.infrastructure.repository

import com.project.todo.domain.repository.TodoRepository
import com.project.todo.infrastructure.mapper.*
import com.project.todo.infrastructure.mapper.TodoDynamicSqlSupport.Todo.userId
import com.project.todo.domain.model.TodoRecord
import com.project.todo.utils.factory.CreateSessionFactory
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryImpl(
    private val createSessionFactory: CreateSessionFactory
): TodoRepository {
    override fun create(todoRecord: TodoRecord) {
        createSessionFactory.newFactory()
            .openSession()
            .use {
                session ->
                val mapper = session.getMapper(TodoMapper::class.java)
                mapper.insert(todoRecord)
                session.commit()
            }
    }

    override fun select(todoId: Int): TodoRecord? {
        createSessionFactory.newFactory()
            .openSession()
            .use {
                session ->
                val mapper = session.getMapper(TodoMapper::class.java)
                return mapper.selectByPrimaryKey(todoId)
            }
    }

    override fun selectByUid(uid: Int): List<TodoRecord> {
        var todos: List<TodoRecord>
        createSessionFactory.newFactory()
            .openSession()
            .use {
                session ->
                val mapper = session.getMapper(TodoMapper::class.java)
                todos = mapper.select {
                    where(userId, isEqualTo(uid))
                }
            }

        return todos
    }

    override fun update(todoRecord: TodoRecord) {
        createSessionFactory.newFactory()
            .openSession()
            .use {
                session ->
                val mapper = session.getMapper(TodoMapper::class.java)
                mapper.updateByPrimaryKeySelective(todoRecord)
                session.commit()
            }
    }
}