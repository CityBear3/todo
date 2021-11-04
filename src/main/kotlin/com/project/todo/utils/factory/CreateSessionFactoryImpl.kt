package com.project.todo.utils.factory

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.springframework.stereotype.Component

@Component
class CreateSessionFactoryImpl: CreateSessionFactory {
    override fun newFactory(): SqlSessionFactory {
        val resource = "mybatis-config.xml"
        val inputStream = Resources.getResourceAsStream(resource)
        return SqlSessionFactoryBuilder().build(inputStream)
    }
}