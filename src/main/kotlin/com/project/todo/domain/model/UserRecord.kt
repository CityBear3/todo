/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.project.todo.domain.model

import com.project.todo.domain.model.enum.RoleType
import java.util.Date

data class UserRecord(
    var id: Int? = null,
    var username: String? = null,
    var email: String? = null,
    var password: String? = null,
    var role: RoleType? = null,
    var createTime: Date? = null
)