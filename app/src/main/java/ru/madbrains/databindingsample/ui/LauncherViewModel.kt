package ru.madbrains.databindingsample.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class LauncherViewModel : ViewModel() {

    val launchLiveData = MutableLiveData<LaunchDestination>()

    init {
        launchLiveData.value = (LaunchDestination.PRODUCTS_ACTIVITY)
    }
}

enum class LaunchDestination {
    PRODUCTS_ACTIVITY
}