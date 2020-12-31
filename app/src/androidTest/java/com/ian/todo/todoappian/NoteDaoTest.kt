package com.ian.todo.todoappian

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ian.todo.todoappian.constants.TestConstants
import db.NoteTask
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*


@RunWith(AndroidJUnit4::class)
class UserDaoTest : DBTest() {



    @Test
    fun insertAndLoad() {
        val now = Date()
        val entities = NoteTask(
            1,
            TestConstants.title,
            TestConstants.content,
            TestConstants.imgurl,
            now,
            false
        )
        db.notedao.insertNoteTask(entities).blockingAwait()

        db.notedao.getNoteTasks().test().assertValue { list ->
            list.isNotEmpty()

        }


    }

    @Test
    fun checkTaskUpdateHappensCorrectly() {
        val now = Date()
        var inserted = NoteTask(
            1,
            TestConstants.title,
            TestConstants.content,
            TestConstants.imgurl,
            now,
            false
        )
        db.notedao.insertNoteTask(inserted).blockingAwait()

        inserted.title = "Updated Title"
        db.notedao.updateNoteTask(inserted).blockingAwait()

        val loaded = db.notedao.getNoteTaskById(inserted.id!!)
        Assert.assertEquals(loaded.title, "Updated Title")


    }


    @Test
    fun checkDeleteHappensCorrectly() {
        val now = Date()
        val task = NoteTask(
            1,
            TestConstants.title,
            TestConstants.content,
            TestConstants.imgurl,
            now,
            false
        )
        db.notedao.insertNoteTask(task).blockingAwait()

        db.notedao.deleteNoteTask(task)
        db.notedao.getNoteTasks().test().assertValue { list ->
            list.isEmpty()

        }


    }
}