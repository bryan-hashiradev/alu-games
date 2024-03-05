package com.alugames.models

import java.math.BigDecimal

sealed class Plan(val type: String) {
    open fun rentPrice(rent: GameRent): BigDecimal? {
        return rent.game.price?.times(rent.periodRent.days.toBigDecimal())
    }
}