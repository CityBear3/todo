package com.project.todo.utils.factory

import org.apache.ibatis.session.SqlSessionFactory
import org.springframework.stereotype.Component

@Component
interface CreateSessionFactory {
    fun newFactory(): SqlSessionFactory
}