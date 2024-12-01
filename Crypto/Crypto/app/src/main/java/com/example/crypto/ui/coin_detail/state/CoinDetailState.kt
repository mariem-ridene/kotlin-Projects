package com.example.crypto.ui.coin_detail.state

import com.example.crypto.domain.models.CoinDetail

data class CoinDetailState(
    val coinDetail:CoinDetail ?= null,
    val isLoading:Boolean = false,
    val error:String = ""
)