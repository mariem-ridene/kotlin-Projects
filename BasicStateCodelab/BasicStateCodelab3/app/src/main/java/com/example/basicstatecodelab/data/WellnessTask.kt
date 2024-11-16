package com.example.basicstatecodelab.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }