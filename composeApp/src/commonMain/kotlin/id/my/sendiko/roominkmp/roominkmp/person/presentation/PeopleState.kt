package id.my.sendiko.roominkmp.roominkmp.person.presentation

import id.my.sendiko.roominkmp.roominkmp.person.domain.Person

data class PeopleState(
    val people: List<Person> = emptyList(),
    val isShowingInputModal: Boolean = false,
    val nameField: String = "",
)
