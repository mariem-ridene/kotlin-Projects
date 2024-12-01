package com.example.crypto.data.repositories

import com.example.crypto.data.data_sources.remote.dto.CoinDetailDto
import com.example.crypto.data.data_sources.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String): CoinDetailDto
}