package com.alugames.models

class GameRent(
    private val gamer: GamerModel,
    private val game: GameModel,
    private val periodRent: PeriodRent,
) {
    private val rentPrice
        get() = game.price?.times(periodRent.days) ?: 0.0
    override fun toString(): String {
        return """
            Aluguel para ${gamer.tagUser}
            Jogo ${game.title}
            Valor ${String.format("R$%.2f", rentPrice)}
        """.trimIndent()
    }
}