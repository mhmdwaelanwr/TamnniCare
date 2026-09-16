package com.tamnnilabs.care

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import platform.Foundation.NSNotificationCenter
import platform.UIKit.UIApplicationDidBecomeActiveNotification
import ui.state.DailyReassuranceRefreshIntent

@Composable
fun IosActiveRefreshBridge(content: @Composable () -> Unit) {
    DisposableEffect(Unit) {
        val center = NSNotificationCenter.defaultCenter
        val observer = center.addObserverForName(
            name = UIApplicationDidBecomeActiveNotification,
            `object` = null,
            queue = null
        ) { _ ->
            DailyReassuranceRefreshIntent.onAppBecameActive()
        }

        onDispose {
            center.removeObserver(observer)
        }
    }

    content()
}
