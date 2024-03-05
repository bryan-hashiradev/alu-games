package com.alugames.models

class DefaultPlan(type: String = "BRONZE") : Plan(type) {

    override fun rentPrice(rent: GameRent): Double? {
        val price = super.rentPrice(rent)
        return if (rent.gamer.media > 8) {
            price?.times(0.9) ?: 0.0
        } else {
            price
        }
    }
}