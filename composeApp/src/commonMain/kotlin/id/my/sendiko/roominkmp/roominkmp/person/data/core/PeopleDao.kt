package id.my.sendiko.roominkmp.roominkmp.person.data.core

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import id.my.sendiko.roominkmp.roominkmp.person.data.models.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PeopleDao {

    @Query("SELECT * from personentity")
    fun getPeople(): Flow<List<PersonEntity>>

    @Upsert
    suspend fun upsertPerson(personEntity: PersonEntity)

    @Delete
    suspend fun deletePerson(personEntity: PersonEntity)

}