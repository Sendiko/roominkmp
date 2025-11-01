package id.my.sendiko.roominkmp.roominkmp.person.domain

import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    fun getPeople(): Flow<List<Person>>
    suspend fun addPerson(name: String)
    suspend fun deletePerson(person: Person)

}