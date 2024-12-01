package com.example.imcproject.ui.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrackingViewModel : ViewModel() {

    // Recommandations (simulées dans cet exemple)
    private val _recommendations = MutableStateFlow(listOf<Recommendation>())
    val recommendations: StateFlow<List<Recommendation>> = _recommendations

    // État du poids actuel
    private val _weightState = MutableStateFlow("")
    val weightState: StateFlow<String> = _weightState

    init {
        // Initialisation des données (par exemple, des recommandations)
        loadRecommendations()
    }

    private fun loadRecommendations() {
        // Simuler des données de recommandations
        val sampleData = listOf(
            Recommendation("Buvez 2 litres d'eau par jour."),
            Recommendation("Pratiquez 30 minutes d'exercice quotidien."),
            Recommendation("Évitez les sucres raffinés.")
        )
        _recommendations.value = sampleData
    }

    fun updateWeight(newWeight: String) {
        _weightState.value = newWeight
    }

    fun submitWeight() {
        viewModelScope.launch {
            // Logique pour soumettre le poids (API, Firebase, etc.)
            println("Poids soumis : ${_weightState.value}")
        }
    }
}

data class Recommendation(val text: String)
