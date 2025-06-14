package com.example.amphibians.model

import kotlinx.serialization.Serializable


@Serializable
data class AmphibianPhoto(
    val name: String,
    val type: String,
    val description: String,
    val img_src: String
)
