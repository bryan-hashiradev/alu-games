package com.alugames.models

import java.math.BigDecimal

class PlanDefaultModel(type: String = "BRONZE", id: Int = 0) : PlanModel(type, id) {

    override fun rentPrice(rent: GameRentModel): BigDecimal {
        val price = super.rentPrice(rent)
        return if (rent.gamer.media > BigDecimal(8)) {
            price?.times(BigDecimal(0.9)) ?: BigDecimal(0)
        } else {
            price
        }
    }

    override fun toString(): String {
        return """
            
            ID:   ${this.id}
            TIPO: ${this.type}
            
        """.trimIndent()
    }
}