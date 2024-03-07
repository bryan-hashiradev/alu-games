package com.alugames.database

import com.alugames.models.GameModel
import javax.persistence.EntityManager

class GamesDAO(private val entityManager: EntityManager) {
    fun getGames(): List<GameModel> {
        val query = entityManager.createQuery("FROM GameEntity", GameEntity::class.java)
        return query.resultList.map {
            GameModel(
                it.title,
                it.thumb,
                it.description,
                it.price,
                it.id
            )
        }
    }
}