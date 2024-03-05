package com.alugames.models

class GameRent(
     val gamer: GamerModel,
     val game: GameModel,
     val periodRent: PeriodRent,
) {
    private val rentPrice = gamer.plan.rentPrice(this)
    fun monthGamesRented(monthValue: Int) = gamer.historyRent.filter{
        gameRent -> gameRent.periodRent.initialDate.monthValue == monthValue
    }.map { gameRent -> gameRent.game }


    override fun toString(): String {
        return """
            ${gamer.tagUser} - Plano: ${this.gamer.plan.type}
            Jogo ${game.title}
            Valor ${String.format("R$%.2f", rentPrice)}
        """.trimIndent()
    }
}