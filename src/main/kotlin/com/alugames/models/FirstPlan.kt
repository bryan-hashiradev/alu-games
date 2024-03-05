package com.alugames.models

import java.math.BigDecimal

class FirstPlan(
    type: String = "PRATA",
    val gamesIncluded: Int,
    val fees: Double,
    private val discountPercentage: BigDecimal,
): Plan(type) {

    override fun rentPrice(rent: GameRent): BigDecimal? {
        val gamesRented = rent.monthGamesRented(rent.periodRent.initialDate.monthValue).size + 1
        val price = super.rentPrice(rent)

        return if (gamesRented <= gamesIncluded) {
            BigDecimal(0)
        } else if(rent.gamer.media > BigDecimal(8)) {
            val discount = price?.times(discountPercentage)
            price?.minus(discount ?: BigDecimal(0))
        } else {
            price
        }
    }
}