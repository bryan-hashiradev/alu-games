package com.alugames.models

interface Recommended {
    val media: Double
    fun recommend(note: Int)
}