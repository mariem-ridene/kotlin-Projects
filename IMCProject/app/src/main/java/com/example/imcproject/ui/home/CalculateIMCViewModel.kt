package com.example.imcproject.ui.home

import androidx.lifecycle.ViewModel
import com.example.imcproject.data.repositories.IMCRepository
import com.example.imcproject.domain.usecases.CalculateIMCUseCase

import java.util.*

class CalculateIMCViewModel(
    private val calculateIMCUseCase: CalculateIMCUseCase,
    private val imcRepository: IMCRepository
) : ViewModel() {

    fun saveIMCData(
        age: String,
        height: String,
        weight: String,
        gender: String,
        imc: Double,
        category: String,
        userId: String
    ) {
        // Appellez les méthodes du repository ou utilisez le use case pour sauvegarder les données
        imcRepository.saveIMC(
            age = age,
            height = height,
            weight = weight,
            gender = gender,
            imc = imc,
            category = category,
            userId = userId
        )
    }
}