/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.project.todo.infrastructure.mapper

import com.project.todo.domain.model.enum.RoleType
import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("user") {
        val id = column<Int>("id", JDBCType.INTEGER)

        val username = column<String>("username", JDBCType.VARCHAR)

        val email = column<String>("email", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val role = column<RoleType>("role", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)
    }
}