package id.my.sendiko.roominkmp.roominkmp.person.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import roominkmp.composeapp.generated.resources.Res
import roominkmp.composeapp.generated.resources.person_screen_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleScreen(
    state: PeopleState,
    onEvent: (PeopleEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(stringResource(resource = Res.string.person_screen_title))
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onEvent(PeopleEvent.OnTriggerBottomModal(!state.isShowingInputModal)) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) { paddingValues    ->
        if (state.isShowingInputModal) {
            ModalBottomSheet(
                onDismissRequest = { onEvent(PeopleEvent.OnTriggerBottomModal(!state.isShowingInputModal)) },
                content = {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Create new person",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(Modifier.height(8.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = state.nameField,
                            onValueChange = {
                                onEvent(PeopleEvent.OnFieldChanged(it))
                            }
                        )
                        Spacer(Modifier.height(8.dp))
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { onEvent(PeopleEvent.AddPerson) },
                            content = { Text(text = "Add") }
                        )
                    }
                }
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(top = paddingValues.calculateTopPadding() + 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.people, key = { it.id }) { person ->
                Surface(
                    onClick = { onEvent(PeopleEvent.DeletePerson(person)) }
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = person.name
                        )
                        IconButton(
                            onClick = { onEvent(PeopleEvent.DeletePerson(person)) },
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PeopleScreenPreview() {
    PeopleScreen(
        state = PeopleState(),
        onEvent = {}
    )
}