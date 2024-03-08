package com.alugames.database

import com.alugames.models.GamerModel
import javax.persistence.EntityManager

class GamerDAO(private val entityManager: EntityManager) {
    fun getGamers(): List<GamerModel> {
        val query = entityManager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map {
            GamerModel(
                it.name,
                it.email,
                it.birthDate,
                it.userName,
            )
        }
    }
    fun addGamer(gamer: GamerModel) {
        entityManager.transaction.begin()
        entityManager.persist(GamerEntity(
            gamer.name,
            gamer.email,
            gamer.birthDate,
            gamer.userName,
        ))
        entityManager.transaction.commit()
    }
}