package id.my.sendiko.roominkmp.roominkmp.person.data

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import id.my.sendiko.roominkmp.roominkmp.person.data.core.PeopleDatabase

fun getPeopleDatabase(context: Context): PeopleDatabase {
    val dbFile = context.getDatabasePath("people.db")
    return Room.databaseBuilder(context, PeopleDatabase::class.java, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .build()
}