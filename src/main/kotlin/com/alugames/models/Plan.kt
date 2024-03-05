package com.alugames.models

sealed class Plan(val type: String) {
    open fun rentPrice(rent: GameRent): Double? {
        return rent.game.price?.times(rent.periodRent.days)
    }
}