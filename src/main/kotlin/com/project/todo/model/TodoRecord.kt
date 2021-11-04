/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-11-04T10:08:11.4397947+09:00
 */
package com.project.todo.model

import java.util.Date

data class TodoRecord(
    var id: Int? = null,
    var title: String? = null,
    var description: String? = null,
    var done: Byte? = null,
    var userId: Int? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null
)