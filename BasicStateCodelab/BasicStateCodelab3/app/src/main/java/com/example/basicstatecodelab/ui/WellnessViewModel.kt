package com.example.basicstatecodelab.ui

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.basicstatecodelab.data.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }