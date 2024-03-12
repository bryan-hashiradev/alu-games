package com.alugames.models

import java.math.BigDecimal

class PlanSubscribeModel(
    type: String = "PRATA",
    val gamesIncluded: Int,
    val fees: BigDecimal,
    val discountPercentage: BigDecimal,
    id: Int = 0,
): PlanModel(type, id) {

    override fun rentPrice(rent: GameRentModel): BigDecimal {
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

    override fun toString(): String {
        return """
            
            ID:                     ${this.id}
            TIPO:                   ${this.type}
            JOGOS INCLUIDOS:        ${this.gamesIncluded}
            MENSALIDADE:            ${this.fees}
            PERCENTUAL DE DESCONTO: ${this.discountPercentage}
            
        """.trimIndent()
    }
}