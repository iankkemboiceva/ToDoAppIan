package com.ian.todo.todoappian

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import db.AppDatabase
import db.ToDoTask
import db.ToDoTaskDao
import di.roomTestModule
import org.junit.*
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.inject
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import java.util.*


@RunWith(AndroidJUnit4::class)
class AddTaskInstrumentedTest : KoinTest {


    /*
     * Inject needed components from Koin
     */
    val appDB: AppDatabase by inject()
    val tododao: ToDoTaskDao by inject()

    /**
     * Override default Koin configuration to use Room in-memory database
     */
    @Before()
    fun before() {

       loadKoinModules(roomTestModule)
    }

    /**
     * Close resources
     */
    @After
    fun after() {
        appDB.close()
       stopKoin()
    }

    @Test
    fun testSave() {

        val now = Date()


        val entities = ToDoTask(null,"Sample Title,","Sample Content","Image url",now,false)

            // Save entities
            tododao.insertToDoTask(entities)

            // Keep id for each one
            val ids = entities.title

            // Request one entity per id
            val requestedEntities = tododao.getToDoTaskById(entities.id!!).title

            // compare result
            Assert.assertEquals(ids, requestedEntities)

    }
}