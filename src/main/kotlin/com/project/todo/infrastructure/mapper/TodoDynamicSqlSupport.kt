/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.project.todo.infrastructure.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object TodoDynamicSqlSupport {
    object Todo : SqlTable("todo") {
        val id = column<Int>("id", JDBCType.INTEGER)

        val title = column<String>("title", JDBCType.VARCHAR)

        val description = column<String>("description", JDBCType.VARCHAR)

        val done = column<Byte>("done", JDBCType.TINYINT)

        val userId = column<Int>("user_id", JDBCType.INTEGER)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)

        val updateTime = column<Date>("update_time", JDBCType.TIMESTAMP)
    }
}