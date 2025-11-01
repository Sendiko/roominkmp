package id.my.sendiko.roominkmp.roominkmp.person.data

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import id.my.sendiko.roominkmp.roominkmp.person.data.core.PeopleDatabase
import platform.Foundation.NSHomeDirectory

fun getPeopleDatabase(): PeopleDatabase {
    val dbFile = NSHomeDirectory() + "/people.db"
    return Room.databaseBuilder<PeopleDatabase>(
        name = dbFile,
        factory = { PeopleDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}