package com.alugames.main

import com.alugames.database.Database
import com.alugames.database.GamesDAO
import com.alugames.models.GameModel
import com.alugames.services.APIGitHubContentsJSONService

fun main () {
    val entityManager = Database.getEntityMananger()
    try {
        val gamesDao = GamesDAO(entityManager)
        val list = gamesDao.getGames()
        list.forEach {
            println(it)
            println()
        }

    } finally {
        entityManager.close()
    }

}