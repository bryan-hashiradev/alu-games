package com.alugames.main

import com.alugames.database.Database
import com.alugames.database.GamerDAO
import com.alugames.database.PlanDAO
import com.alugames.models.GamerModel

fun main() {
//    val gamer1 = GamerModel("bryan", "teste@email.com")
    val gamer1 = GamerModel("bryan", "teste@email.com", "29/12/1998", "hashira")
    val gamer2 = GamerModel("brutos", "bile@brutos.com", "20/02/1999", "theButcher")
    println(gamer2)
    val mng = Database.getEntityMananger()
    val gamerDAO = GamerDAO(mng)
    val planDAO = PlanDAO(mng)

//    gamerDAO.add(gamer2)
    gamerDAO.getList().forEach { println(it) }
    mng.close()
//
//    val plan = planDAO.getByID(3)
//
//    println(plan)
//    gamer1.plan = plan
//
////    println(gamer1)
//
////    gamerDAO.add(gamer1)

//
//    gamerDAO.getList().forEach { println(it) }
//
//    mng.close()
}