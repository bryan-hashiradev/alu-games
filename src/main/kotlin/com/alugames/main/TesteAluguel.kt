package com.alugames.main

import com.alugames.database.Database
import com.alugames.database.GameDAO
import com.alugames.database.GameRentDAO
import com.alugames.database.GamerDAO
import com.alugames.models.PeriodRent

fun main() {
    val mng = Database.getEntityMananger()
    val gameRentDAO = GameRentDAO(mng)
    val gamerDAO = GamerDAO(mng)
    val gameDAO = GameDAO(mng)

//    gamerDAO.getList().forEach {
//        println(it)
//    }

    val gamer = gamerDAO.getByID(14)
    val game = gameDAO.getByID(3)
    val rent = gamer.rentGame(game, PeriodRent())

    gameRentDAO.add(rent)

    gameRentDAO.getList().forEach { println(it) }

    mng.close()
}