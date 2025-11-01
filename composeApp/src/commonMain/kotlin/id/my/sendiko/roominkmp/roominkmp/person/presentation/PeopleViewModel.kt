package id.my.sendiko.roominkmp.roominkmp.person.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.my.sendiko.roominkmp.roominkmp.person.domain.PersonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PeopleViewModel(
    private val repository: PersonRepository
): ViewModel() {

    private val _people = repository.getPeople()
    private val _state = MutableStateFlow(PeopleState())
    val state = combine(_people, _state) { people, state ->
        state.copy(people = people)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PeopleState())

    fun onEvent(event: PeopleEvent) {
        when (event) {
            is PeopleEvent.AddPerson -> viewModelScope.launch {
                repository.addPerson(state.value.nameField)
                _state.update { it.copy(nameField = "", isShowingInputModal = false) }
            }
            is PeopleEvent.DeletePerson -> viewModelScope.launch {
                repository.deletePerson(event.person)
            }

            is PeopleEvent.OnFieldChanged -> _state.update { it.copy(nameField = event.field) }
            is PeopleEvent.OnTriggerBottomModal -> _state.update { it.copy(isShowingInputModal = event.isVisible) }
        }
    }

}