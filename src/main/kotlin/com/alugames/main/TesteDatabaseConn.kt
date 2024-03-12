package com.alugames.main

import com.alugames.database.Database
import com.alugames.database.GamerDAO
import com.alugames.services.APIGitHubContentsJSONService

fun main () {
    val entityManager = Database.getEntityMananger()
    try {
        val service = APIGitHubContentsJSONService()
        val gamers = service.getGamers()

        println(gamers)

        val gamerDao = GamerDAO(entityManager)

//        gamerDao.add(gamers[0])
        println(gamerDao.getList())

//        val gameDao = GameDao(entityManager)
//        var list = gameDao.getList()
//        list.forEach {
//            println(it)
//            println()
//        }

//        gameDao.add(GameModel(
//            "Hades",
//            "https://cdn.cloudflare.steamstatic.com/steam/apps/1145360/header.jpg?t=1680293801",
//            "Um jogo de ação e roguelike, onde você assume o papel do filho do deus dos mortos e luta para escapar do submundo grego.",
//            BigDecimal(4.99).setScale(2, RoundingMode.HALF_EVEN)
//            ))

//        println(gameDao.getByID(22))

//        list = gameDao.getList()
//        list.forEach {
//            println(it)
//            println()
//        }

    } finally {
        entityManager.close()
    }

}