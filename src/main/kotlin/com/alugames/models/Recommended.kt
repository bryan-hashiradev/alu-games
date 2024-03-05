package com.alugames.models

import java.math.BigDecimal

interface Recommended {
    val media: BigDecimal
    fun recommend(note: Int)
}