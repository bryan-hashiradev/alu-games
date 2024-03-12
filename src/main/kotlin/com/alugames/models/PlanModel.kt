package com.alugames.models

import java.math.BigDecimal

sealed class PlanModel(val type: String, val id: Int = 0) {
    open fun rentPrice(rent: GameRentModel): BigDecimal {
        val price = rent.game.price
        return price?.times(rent.periodRent.days.toBigDecimal()) ?: BigDecimal(0)
    }
}