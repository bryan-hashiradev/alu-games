package com.alugames.main

import com.alugames.models.FirstPlan
import com.alugames.models.PeriodRent
import com.alugames.services.APIGitHubContentsJSONService
import java.time.LocalDate
import kotlin.random.Random

fun main() {
    val service = APIGitHubContentsJSONService()
    val gamers = service.getGamers()
    val games = service.getGames()
//    println(games)
////    println(gamers)
//    val mixGames = games.shuffled()
//    val mixGamers = gamers.shuffled()


    val exampleGame = games[0]
    val exampleGame2 = games[1]
    val exampleGame3 = games[2]
    val exampleGamer1 = gamers[0]
    val exampleGamer2 = gamers[1]

    exampleGamer2.plan = FirstPlan(fees = 9.0, gamesIncluded = 3, discountPercentage = 0.5)

    exampleGamer1.recommend(8)
    exampleGamer1.recommend(1)
    exampleGamer1.recommend(8)
    exampleGamer1.recommend(8)
    exampleGamer1.recommend(8)
    exampleGamer1.recommend(8)
    exampleGamer1.recommend(10)
    exampleGamer1.recommend(10)
    exampleGamer1.recommend(10)
    exampleGamer1.recommend(10)

    val periodRent = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(12))
    val periodRent2 = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodRent3 = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(7))

    val rent1 = exampleGamer1.rentGame(exampleGame, periodRent)
    val rent2 = exampleGamer1.rentGame(exampleGame2, periodRent2)
    val rent3 = exampleGamer1.rentGame(exampleGame3, periodRent3)

    val rent4 = exampleGamer2.rentGame(exampleGame, periodRent)
    val rent5 = exampleGamer2.rentGame(exampleGame2, periodRent2)
    val rent6 = exampleGamer2.rentGame(exampleGame3, periodRent3)
    val rent7 = exampleGamer2.rentGame(exampleGame3, periodRent3)
    val rent8 = exampleGamer2.rentGame(exampleGame3, periodRent3)

    println()
    println("S/ ASSINATURA")
    exampleGamer1.historyRent.forEach { println(it) }

    println()
    println("C/ ASSINATURA")

    exampleGamer2.historyRent.forEach { println(it) }



}

