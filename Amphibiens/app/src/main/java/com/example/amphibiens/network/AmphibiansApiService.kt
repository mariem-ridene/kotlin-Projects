package com.example.amphibiens.network


import com.example.amphibians.model.Amphibian
import com.example.amphibiens.model.Amphibian
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}