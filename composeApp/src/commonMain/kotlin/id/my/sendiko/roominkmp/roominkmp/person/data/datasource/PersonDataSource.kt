package id.my.sendiko.roominkmp.roominkmp.person.data.datasource

import id.my.sendiko.roominkmp.roominkmp.person.data.models.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonDataSource {

    fun getPeople(): Flow<List<PersonEntity>>
    suspend fun addPerson(person: PersonEntity)
    suspend fun deletePerson(person: PersonEntity)

}