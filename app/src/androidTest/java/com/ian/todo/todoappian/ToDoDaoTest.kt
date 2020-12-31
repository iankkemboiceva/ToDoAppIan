package com.ian.todo.todoappian

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ian.todo.todoappian.constants.TestConstants
import db.ToDoTask
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*


@RunWith(AndroidJUnit4::class)
class UserDaoTest : DBTest() {



    @Test
    fun insertAndLoad() {
        val now = Date()
        val entities = ToDoTask(
            1,
            TestConstants.title,
            TestConstants.content,
            TestConstants.imgurl,
            now,
            false
        )
        db.todoDao.insertToDoTask(entities)

        val loaded = db.todoDao.getToDoTaskById(entities.id!!)
        Assert.assertEquals(loaded.title, TestConstants.title)


    }

    @Test
    fun checkTaskUpdateHappensCorrectly() {
        val now = Date()
        var inserted = ToDoTask(
            1,
            TestConstants.title,
            TestConstants.content,
            TestConstants.imgurl,
            now,
            false
        )
        db.todoDao.insertToDoTask(inserted)

        inserted.title = "Updated Title"
        db.todoDao.updateToDoTask(inserted)
        val loaded = db.todoDao.getToDoTaskById(inserted.id!!)
        Assert.assertEquals(loaded.title, "Updated Title")


    }

    @Test
    fun checkDeleteHappensCorrectly() {
        val now = Date()
        val entities = ToDoTask(
            1,
            TestConstants.title,
            TestConstants.content,
            TestConstants.imgurl,
            now,
            false
        )
        db.todoDao.insertToDoTask(entities)

        db.todoDao.deleteToDoTask(entities)
        val loaded = db.todoDao.getToDoTaskById(entities.id!!)
        Assert.assertNull(loaded)


    }
}