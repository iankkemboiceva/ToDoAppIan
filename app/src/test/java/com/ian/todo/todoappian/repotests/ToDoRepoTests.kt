package com.ian.todo.todoappian.repotests


import com.ian.todo.todoappian.constants.TestConstants
import db.ToDoTask
import db.ToDoTaskDao
import org.junit.Before
import org.junit.Test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import repositories.ToDoRepo

import org.junit.Assert
import org.mockito.ArgumentMatchers.anyLong

import java.util.*

class ToDoRepoTests {

    lateinit var ToDoTaskRepository: ToDoRepo


    lateinit var tododao: ToDoTaskDao

//Utilities

    lateinit var ToDoTaskFromDao: ToDoTask


    @Before
    fun setUp() {


        tododao = mock()
   //     whenever(tododao.getToDoTaskById(anyLong())).thenReturn(ToDoTaskFromDao)

        ToDoTaskRepository = ToDoRepo(tododao)
    }

    @Test
    fun repositoryAddsCorrectly() {
        val now = Date()
        val task = ToDoTask(
            1,
            TestConstants.title,
            TestConstants.content,
            TestConstants.imgurl,
            now,
            false
        )


        ToDoTaskRepository.addTask(task)
        val requestedtask = tododao.getToDoTaskById(task.id!!).title
        Assert.assertEquals(task.title, requestedtask)
    }
}
