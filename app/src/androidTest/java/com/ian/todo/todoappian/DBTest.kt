package com.ian.todo.todoappian


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import db.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.TimeUnit

abstract class DBTest {
    @Rule
    @JvmField

    var instantTaskExecutorRule: InstantTaskExecutorRule? = InstantTaskExecutorRule()
    private lateinit var _db: AppDatabase
    val db: AppDatabase
        get() = _db

    @Before
    fun initDb() {
        _db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() {

        _db.close()
    }
}