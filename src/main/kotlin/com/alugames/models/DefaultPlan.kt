package com.alugames.models

import java.math.BigDecimal

class DefaultPlan(type: String = "BRONZE") : Plan(type) {

    override fun rentPrice(rent: GameRent): BigDecimal? {
        val price = super.rentPrice(rent)
        return if (rent.gamer.media > BigDecimal(8)) {
            price?.times(BigDecimal(0.9)) ?: BigDecimal(0)
        } else {
            price
        }
    }
}