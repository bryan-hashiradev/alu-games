package com.alugames.main

import com.alugames.database.Database
import com.alugames.database.PlanDAO
import com.alugames.models.PlanDefaultModel
import com.alugames.models.PlanSubscribeModel
import java.math.BigDecimal
import javax.persistence.EntityManager

fun main() {
    val avulso = PlanDefaultModel("BRONZE")
    val prata = PlanSubscribeModel("PRATA", 3, BigDecimal(9.90), BigDecimal(0.15))
    val ouro = PlanSubscribeModel("OURO", 5, BigDecimal(19.90), BigDecimal(0.20))
    val platina = PlanSubscribeModel("PLATINA", 10, BigDecimal(29.90), BigDecimal(0.30))
    val diamante = PlanSubscribeModel("DIAMANTE", 20, BigDecimal(49.90), BigDecimal(0.50))

    val manager = Database.getEntityMananger()
    val planDao = PlanDAO(manager)
//    planDao.add(avulso)
//    planDao.add(prata)
//    planDao.add(ouro)
//    planDao.add(platina)
//    planDao.add(diamante)

    val lista = planDao.getList()

    lista.forEach { println(it) }
    manager.close()
}