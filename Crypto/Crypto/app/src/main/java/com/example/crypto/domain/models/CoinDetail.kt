package com.example.crypto.domain.models

import com.example.crypto.data.data_sources.remote.dto.Team

data class CoinDetail (
    val description: String,
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<Team>
)