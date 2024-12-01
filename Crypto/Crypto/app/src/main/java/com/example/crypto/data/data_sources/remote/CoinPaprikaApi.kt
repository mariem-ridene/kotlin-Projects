package com.example.crypto.data.data_sources.remote

import com.example.crypto.common.Constants
import com.example.crypto.data.data_sources.remote.dto.CoinDetailDto
import com.example.crypto.data.data_sources.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path(Constants.PARAM_COIN_ID) coinId:String) : CoinDetailDto
}