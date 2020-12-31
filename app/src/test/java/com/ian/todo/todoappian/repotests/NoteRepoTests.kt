package com.ian.todo.todoappian.repotests


import com.ian.todo.todoappian.constants.TestConstants
import db.NoteTask
import db.NoteTaskDao
import org.junit.Before
import org.junit.Test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import repositories.NoteRepo

import org.junit.Assert
import org.mockito.ArgumentMatchers.anyLong

import java.util.*

class NoteRepoTests {

    lateinit var NoteTaskRepository: NoteRepo


    lateinit var tododao: NoteTaskDao

    private val task = NoteTask(
        1,
        TestConstants.title,
        TestConstants.content,
        TestConstants.imgurl,
        Date(),
        false
    )
    lateinit var NoteTaskFromDao: NoteTask


    @Before
    fun setUp() {


        tododao = mock()
   //     whenever(tododao.getNoteTaskById(anyLong())).thenReturn(NoteTaskFromDao)
        runBlocking {

            whenever(tododao.getNoteTaskById(anyLong())).thenReturn(task)
        }
        NoteTaskRepository = NoteRepo(tododao)
    }

    @Test
    fun repositoryAddsCorrectly() {
        val now = Date()



        NoteTaskRepository.addTask(task)
        val requestedtask = NoteTaskRepository.getloadTaskById(task.id!!).title
        Assert.assertEquals(task.title, requestedtask)
    }

    @Test
    fun repositoryUpdatesCorrectly() {



        val updatedtask = task
        updatedtask.title = "Updated Title"
        NoteTaskRepository.updateTaskById(updatedtask)
        val requestedtask = NoteTaskRepository.getloadTaskById(updatedtask.id!!).title
        Assert.assertEquals("Updated Title", requestedtask)
    }
}
