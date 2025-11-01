package id.my.sendiko.roominkmp.roominkmp.person.presentation

import id.my.sendiko.roominkmp.roominkmp.person.domain.Person

sealed interface PeopleEvent {
    data object AddPerson: PeopleEvent
    data class DeletePerson(val person: Person): PeopleEvent
    data class OnTriggerBottomModal(val isVisible: Boolean): PeopleEvent
    data class OnFieldChanged(val field: String): PeopleEvent
}