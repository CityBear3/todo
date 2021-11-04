/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-11-04T10:08:11.4226587+09:00
 */
package com.project.todo.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("user") {
        val id = column<Int>("id", JDBCType.INTEGER)

        val username = column<String>("username", JDBCType.VARCHAR)

        val email = column<String>("email", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val isAdmin = column<Byte>("is_admin", JDBCType.TINYINT)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)
    }
}