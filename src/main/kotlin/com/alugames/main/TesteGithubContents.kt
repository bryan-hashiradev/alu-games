package com.alugames.main

import com.alugames.models.PlanSubscribeModel
import com.alugames.services.APIGitHubContentsJSONService
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal

fun main() {
    val service = APIGitHubContentsJSONService()
    val gamers = service.getGamers()
    val games = service.getGames()
//    println(games)
////    println(gamers)
//    val mixGames = games.shuffled()
//    val mixGamers = gamers.shuffled()
//
//
//    val exampleGame = games[0]
//    val exampleGame2 = games[1]
//    val exampleGame3 = games[2]
//    val exampleGamer1 = gamers[0]
    val exampleGamer2 = gamers[1]
//
//    exampleGamer2.plan = PlanSubscribeModel(fees = 9.0, gamesIncluded = 3, discountPercentage = BigDecimal(0.5))
//
//    exampleGamer1.recommend(8)
//    exampleGamer1.recommend(1)
//    exampleGamer1.recommend(0)
//    exampleGamer1.recommend(8)
//    exampleGamer1.recommend(-2)
//    exampleGamer1.recommend(15)
//    exampleGamer1.recommend(10)
//    exampleGamer1.recommend(10)
//    exampleGamer1.recommend(10)
//    exampleGamer1.recommend(10)
//
//    val periodRent = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(12))
//    val periodRent2 = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(3))
//    val periodRent3 = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(7))
//
//    val rent1 = exampleGamer1.rentGame(exampleGame, periodRent)
//    val rent2 = exampleGamer1.rentGame(exampleGame2, periodRent2)
//    val rent3 = exampleGamer1.rentGame(exampleGame3, periodRent3)
//
//    val rent4 = exampleGamer2.rentGame(exampleGame, periodRent)
//    val rent5 = exampleGamer2.rentGame(exampleGame2, periodRent2)
//    val rent6 = exampleGamer2.rentGame(exampleGame3, periodRent3)
//    val rent7 = exampleGamer2.rentGame(exampleGame3, periodRent3)
//    val rent8 = exampleGamer2.rentGame(exampleGame3, periodRent3)
//
//    println()
//    println("S/ ASSINATURA")
//    exampleGamer1.historyRent.forEach { println(it) }
//
//    println()
//    println("C/ ASSINATURA")
//
//    exampleGamer2.historyRent.forEach { println(it) }

//    val gamerCaroline = gamers[3]
    val gamerCamila = gamers[5]
    val jogoResidentVillage = games[10]
    val jogoSpider = games[13]
    val jogoTheLastOfUs = games[2]
    val jogoDandara = games[5]
    val jogoAssassins = games[4]
    val jogoCyber = games[6]
    val jogoGod = games[7]
    val jogoSkyrim = games[18]

    gamerCamila.recommendAGame(jogoResidentVillage, 7)
    gamerCamila.recommendAGame(jogoTheLastOfUs, 10)
    gamerCamila.recommendAGame(jogoAssassins, 8)
    gamerCamila.recommendAGame(jogoCyber, 7)
    gamerCamila.recommendAGame(jogoGod, 10)
    gamerCamila.recommendAGame(jogoDandara, 8)
    gamerCamila.recommendAGame(jogoSkyrim, 8)
    gamerCamila.recommendAGame(jogoSpider, 6)

println(gamerCamila.recommendedGames)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    val serialized = gson.toJson(gamerCamila.recommendedGames)

    val file = File("recommended-game-${gamerCamila.tagUser}")

    file.writeText(serialized)




}

