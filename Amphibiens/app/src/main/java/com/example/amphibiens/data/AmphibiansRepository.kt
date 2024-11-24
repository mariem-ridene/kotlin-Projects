package com.example.amphibiens.data


import com.example.amphibiens.model.Amphibian
import com.example.amphibiens.network.AmphibiansApiService

/**
 * Repository retrieves amphibian data from underlying data source.
 */
interface AmphibiansRepository {
    /** Retrieves list of amphibians from underlying data source */
    suspend fun getAmphibians(): List<Amphibian>
}

/**
 * Network Implementation of repository that retrieves amphibian data from underlying data source.
 */
class DefaultAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    /** Retrieves list of amphibians from underlying data source */
    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
}
