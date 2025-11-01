package id.my.sendiko.roominkmp.roominkmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.my.sendiko.roominkmp.roominkmp.person.presentation.PeopleScreen
import id.my.sendiko.roominkmp.roominkmp.person.presentation.PeopleViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

import roominkmp.composeapp.generated.resources.Res
import roominkmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = koinViewModel<PeopleViewModel>()
        val state by viewModel.state.collectAsState()
        PeopleScreen(
            state = state,
            onEvent = viewModel::onEvent,
        )
    }
}