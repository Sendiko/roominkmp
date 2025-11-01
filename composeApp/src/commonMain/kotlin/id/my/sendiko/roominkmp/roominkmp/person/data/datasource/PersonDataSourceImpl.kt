package id.my.sendiko.roominkmp.roominkmp.person.data.datasource

import id.my.sendiko.roominkmp.roominkmp.person.data.core.PeopleDao
import id.my.sendiko.roominkmp.roominkmp.person.data.models.PersonEntity
import kotlinx.coroutines.flow.Flow

class PersonDataSourceImpl(
    private val peopleDao: PeopleDao,
): PersonDataSource {
    override fun getPeople(): Flow<List<PersonEntity>> {
        return peopleDao.getPeople()
    }

    override suspend fun addPerson(person: PersonEntity) {
        peopleDao.upsertPerson(person)
    }

    override suspend fun deletePerson(person: PersonEntity) {
        peopleDao.deletePerson(person)
    }
}