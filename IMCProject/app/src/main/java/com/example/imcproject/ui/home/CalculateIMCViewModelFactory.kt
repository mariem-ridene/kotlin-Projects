package com.example.imcproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CalculateIMCViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalculateIMCViewModel::class.java)) {
            return CalculateIMCViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}