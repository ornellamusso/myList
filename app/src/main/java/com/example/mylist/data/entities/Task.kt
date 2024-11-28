package com.example.mylist.data.entities

import android.util.Log
import java.nio.channels.AsynchronousFileChannel.open


fun findAll() : List<Task> {
    open()

    var list: MutableList<Task> = mutableListOf()

    try {
        val cursor = db.query(
            Task.TABLE_NAME,       // The table to query
            Task.COLUMN_NAMES,     // The array of columns to return (pass null to get all)
            null,                  // The columns for the WHERE clause
            null,                 // The values for the WHERE clause
            null,                  // don't group the rows
            null,                   // don't filter by row groups
            null                    // The sort order
        )

        while (cursor.moveToNext()) {
            val task = cursorToEntity(cursor)
            list.add(task)
        }
    } catch (e: Exception) {
        Log.e("DB", e.stackTraceToString())
    } finally {
        close()
    }
    return list
}

fun open() {
    TODO("Not yet implemented")
}
fun close() {
    TODO("Not yet implemented")
}
class Task {

}
