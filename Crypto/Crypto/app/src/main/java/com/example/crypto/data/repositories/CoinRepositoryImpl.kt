package com.example.crypto.data.repositories

import com.example.crypto.data.data_sources.remote.CoinPaprikaApi
import com.example.crypto.data.data_sources.remote.dto.CoinDetailDto
import com.example.crypto.data.data_sources.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}
