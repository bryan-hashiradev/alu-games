package com.alugames.main

import com.alugames.models.PeriodRent
import com.alugames.services.APIGitHubContentsJSONService
import java.time.LocalDate
import kotlin.random.Random

fun main() {
    val service = APIGitHubContentsJSONService()
    val gamers = service.getGamers()
    val games = service.getGames()
//    println(games)
//    println(gamers)
    val mixGames = games.shuffled()
    val mixGamers = gamers.shuffled()
    val exampleGame = mixGames.first()
    val exampleGamer = mixGamers.first()
    val periodRent = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(12))
    val rent = exampleGamer.rentGame(exampleGame,periodRent)
    println(rent)
}