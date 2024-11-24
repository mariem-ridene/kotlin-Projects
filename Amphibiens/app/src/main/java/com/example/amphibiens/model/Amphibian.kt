package com.example.amphibiens.model

import kotlinx.serialization.SerialName


/**
 * Data class that defines an amphibian which includes a name, type, description, and image URL.
 */
@Serializable
data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @SerialName("img_src") val imgSrc: String
)
