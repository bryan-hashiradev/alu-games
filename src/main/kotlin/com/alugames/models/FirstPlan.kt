package com.alugames.models

class FirstPlan(
    type: String = "PRATA",
    val gamesIncluded: Int,
    val fees: Double,
    private val discountPercentage: Double,
): Plan(type) {

    override fun rentPrice(rent: GameRent): Double? {
        val gamesRented = rent.monthGamesRented(rent.periodRent.initialDate.monthValue).size + 1
        val price = super.rentPrice(rent)

        return if (gamesRented <= gamesIncluded) {
            0.0
        } else if(rent.gamer.media > 8) {
            val discount = price?.times(discountPercentage)
            price?.minus(discount ?: 0.0)
        } else {
            price
        }
    }
}