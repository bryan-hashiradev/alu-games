package com.alugames.main

import com.alugames.database.Database
import com.alugames.database.GameDao

fun main () {
    val entityManager = Database.getEntityMananger()
    try {
        val gameDao = GameDao(entityManager)
        val list = gameDao.getGames()
        list.forEach {
            println(it)
            println()
        }

    } finally {
        entityManager.close()
    }

}