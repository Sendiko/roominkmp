package id.my.sendiko.roominkmp.roominkmp.person.data.core

import androidx.room.Database
import androidx.room.RoomDatabase
import id.my.sendiko.roominkmp.roominkmp.person.data.models.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = 1,
    exportSchema = true,
)
abstract class PeopleDatabase: RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}