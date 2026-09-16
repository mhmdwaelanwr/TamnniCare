package ui.state

object DailyReassuranceRefreshIntent {
    fun onAppBecameActive() {
        InMemoryDailyReassuranceStateSource.refreshPolicy()
    }
}

