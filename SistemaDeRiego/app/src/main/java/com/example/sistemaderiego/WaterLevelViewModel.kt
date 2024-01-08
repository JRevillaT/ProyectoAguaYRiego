package com.example.sistemaderiego
// WaterLevelViewModel.kt

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WaterLevelViewModel : ViewModel() {

    private val _waterLevels = MutableStateFlow(emptyList<WaterLevel>())
    val waterLevels: StateFlow<List<WaterLevel>> = _waterLevels

    fun initializeWaterLevels() {
        _waterLevels.value = getSampleWaterLevels()
    }
}

