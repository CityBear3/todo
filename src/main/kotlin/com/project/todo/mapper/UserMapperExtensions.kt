/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.project.todo.mapper

import com.project.todo.mapper.UserDynamicSqlSupport.User
import com.project.todo.mapper.UserDynamicSqlSupport.User.createTime
import com.project.todo.mapper.UserDynamicSqlSupport.User.email
import com.project.todo.mapper.UserDynamicSqlSupport.User.id
import com.project.todo.mapper.UserDynamicSqlSupport.User.password
import com.project.todo.mapper.UserDynamicSqlSupport.User.role
import com.project.todo.mapper.UserDynamicSqlSupport.User.username
import com.project.todo.model.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(id_: Int) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toProperty("id")
        map(username).toProperty("username")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(role).toProperty("role")
        map(createTime).toProperty("createTime")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultiple, records, User) {
        map(id).toProperty("id")
        map(username).toProperty("username")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(role).toProperty("role")
        map(createTime).toProperty("createTime")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(username).toPropertyWhenPresent("username", record::username)
        map(email).toPropertyWhenPresent("email", record::email)
        map(password).toPropertyWhenPresent("password", record::password)
        map(role).toPropertyWhenPresent("role", record::role)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
    }

private val columnList = listOf(id, username, email, password, role, createTime)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(id_: Int) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(id).equalTo(record::id)
        set(username).equalTo(record::username)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(role).equalTo(record::role)
        set(createTime).equalTo(record::createTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(username).equalToWhenPresent(record::username)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(role).equalToWhenPresent(record::role)
        set(createTime).equalToWhenPresent(record::createTime)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(username).equalTo(record::username)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(role).equalTo(record::role)
        set(createTime).equalTo(record::createTime)
        where(id, isEqualTo(record::id))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(username).equalToWhenPresent(record::username)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(role).equalToWhenPresent(record::role)
        set(createTime).equalToWhenPresent(record::createTime)
        where(id, isEqualTo(record::id))
    }