package id.my.sendiko.roominkmp.roominkmp.person.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import id.my.sendiko.roominkmp.roominkmp.person.domain.Person

@Entity
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
) {
    fun toDomain(): Person {
        return Person(
            id = id,
            name = name
        )
    }
}