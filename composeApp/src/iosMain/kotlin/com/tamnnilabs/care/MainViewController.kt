package com.tamnnilabs.care

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    IosActiveRefreshBridge {
        App()
    }
}
