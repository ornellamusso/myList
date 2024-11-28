package com.example.mylist.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mylist.data.entities.Task
import com.google.android.gms.gcm.Task
import java.text.DateFormat
import java.util.Calendar
import java.util.Locale

class DatabaseManager(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "ToDoListDatabase.db"


        private const val SQL_CREATE_TABLE =
            "CREATE TABLE ${Task.TABLE_NAME} (" +
                    "${Task.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Task.COLUMN_NAME_TITLE} TEXT," +
                    "${Task.COLUMN_NAME_DESCRIPTION} TEXT," +
                    "${Task.COLUMN_NAME_REMINDER} BOOLEAN," +
                    "${Task.COLUMN_NAME_ALL_DAY} BOOLEAN," +
                    "${Task.COLUMN_NAME_DATE} INTEGER," +
                    "${Task.COLUMN_NAME_TIME} INTEGER," +
                    "${Task.COLUMN_NAME_PRIORITY} INTEGER," +
                    "${Task.COLUMN_NAME_DONE} BOOLEAN)"

        private const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${Task.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onDestroy(db)
        onCreate(db)
    }

    private fun onDestroy(db: SQLiteDatabase) {
        db.execSQL(SQL_DELETE_TABLE)
    }

    fun insertUser(s: String, s1: String, s2: String) {

    }
}
