package com.alugames.main

import com.alugames.database.Database
import com.alugames.database.GamesDAO
import com.alugames.models.GameModel
import com.alugames.services.APIGitHubContentsJSONService

fun main () {
//    val database = Database.getConnection()
//    println(database)
//    val gameList: List<GameModel> = Database.getGames()
    val gamesDao = GamesDAO()

    val list = gamesDao.getGames()

    list.forEach {
        println(it)
        println()
    }
}