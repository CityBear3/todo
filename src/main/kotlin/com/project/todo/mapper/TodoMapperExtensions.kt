/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-11-04T10:08:11.4397947+09:00
 */
package com.project.todo.mapper

import com.project.todo.mapper.TodoDynamicSqlSupport.Todo
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.createTime
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.description
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.done
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.id
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.title
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.updateTime
import com.project.todo.mapper.TodoDynamicSqlSupport.Todo.userId
import com.project.todo.model.TodoRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun TodoMapper.count(completer: CountCompleter) =
    countFrom(this::count, Todo, completer)

fun TodoMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Todo, completer)

fun TodoMapper.deleteByPrimaryKey(id_: Int) =
    delete {
        where(id, isEqualTo(id_))
    }

fun TodoMapper.insert(record: TodoRecord) =
    insert(this::insert, record, Todo) {
        map(id).toProperty("id")
        map(title).toProperty("title")
        map(description).toProperty("description")
        map(done).toProperty("done")
        map(userId).toProperty("userId")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun TodoMapper.insertMultiple(records: Collection<TodoRecord>) =
    insertMultiple(this::insertMultiple, records, Todo) {
        map(id).toProperty("id")
        map(title).toProperty("title")
        map(description).toProperty("description")
        map(done).toProperty("done")
        map(userId).toProperty("userId")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun TodoMapper.insertMultiple(vararg records: TodoRecord) =
    insertMultiple(records.toList())

fun TodoMapper.insertSelective(record: TodoRecord) =
    insert(this::insert, record, Todo) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(title).toPropertyWhenPresent("title", record::title)
        map(description).toPropertyWhenPresent("description", record::description)
        map(done).toPropertyWhenPresent("done", record::done)
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, title, description, done, userId, createTime, updateTime)

fun TodoMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Todo, completer)

fun TodoMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Todo, completer)

fun TodoMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Todo, completer)

fun TodoMapper.selectByPrimaryKey(id_: Int) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun TodoMapper.update(completer: UpdateCompleter) =
    update(this::update, Todo, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: TodoRecord) =
    apply {
        set(id).equalTo(record::id)
        set(title).equalTo(record::title)
        set(description).equalTo(record::description)
        set(done).equalTo(record::done)
        set(userId).equalTo(record::userId)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: TodoRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(title).equalToWhenPresent(record::title)
        set(description).equalToWhenPresent(record::description)
        set(done).equalToWhenPresent(record::done)
        set(userId).equalToWhenPresent(record::userId)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun TodoMapper.updateByPrimaryKey(record: TodoRecord) =
    update {
        set(title).equalTo(record::title)
        set(description).equalTo(record::description)
        set(done).equalTo(record::done)
        set(userId).equalTo(record::userId)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun TodoMapper.updateByPrimaryKeySelective(record: TodoRecord) =
    update {
        set(title).equalToWhenPresent(record::title)
        set(description).equalToWhenPresent(record::description)
        set(done).equalToWhenPresent(record::done)
        set(userId).equalToWhenPresent(record::userId)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }