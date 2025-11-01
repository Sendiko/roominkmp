package id.my.sendiko.roominkmp.roominkmp

import androidx.compose.ui.window.ComposeUIViewController
import id.my.sendiko.roominkmp.roominkmp.core.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }