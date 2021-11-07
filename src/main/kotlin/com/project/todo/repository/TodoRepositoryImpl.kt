package com.project.todo.repository

import com.project.todo.mapper.*
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.userId
import com.project.todo.model.TodoRecord
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