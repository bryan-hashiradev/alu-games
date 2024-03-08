package com.alugames.database

import com.alugames.models.GameModel
import java.math.BigDecimal
import javax.persistence.EntityManager

class GameDao(private val entityManager: EntityManager) {
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

    fun addGame(game: GameModel) {
        val gameEntity = GameEntity(
            game.title,
            game.thumb,
            game.description,
            game.price,
        )
        entityManager.transaction.begin()
        entityManager.persist(gameEntity)
        entityManager.transaction.commit()
    }
}