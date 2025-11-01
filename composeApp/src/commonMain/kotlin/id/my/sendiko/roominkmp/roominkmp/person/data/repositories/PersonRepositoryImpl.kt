package id.my.sendiko.roominkmp.roominkmp.person.data.repositories

import id.my.sendiko.roominkmp.roominkmp.person.data.datasource.PersonDataSource
import id.my.sendiko.roominkmp.roominkmp.person.data.models.PersonEntity
import id.my.sendiko.roominkmp.roominkmp.person.domain.Person
import id.my.sendiko.roominkmp.roominkmp.person.domain.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PersonRepositoryImpl(
    private val dataSource: PersonDataSource,
): PersonRepository {
    override fun getPeople(): Flow<List<Person>> {
        return dataSource.getPeople().map { people -> people.map { it.toDomain()} }
    }

    override suspend fun addPerson(name: String) {
        val personEntity = PersonEntity(
            name = name
        )
        dataSource.addPerson(personEntity)
    }

    override suspend fun deletePerson(person: Person) {
        val personEntity = PersonEntity(
            id = person.id,
            name = person.name
        )
        dataSource.deletePerson(personEntity)
    }
}