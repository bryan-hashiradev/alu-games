package com.alugames.database

import com.alugames.models.GameModel
import javax.persistence.EntityManager

class GameDao(entityManager: EntityManager): DAO<GameModel, GameEntity>(entityManager, GameEntity::class.java) {

    override fun toModel(entity: GameEntity): GameModel {
        return GameModel(
            entity.title,
            entity.thumb,
            entity.description,
            entity.price,
            entity.id
        )
    }

    override fun toEntity(model: GameModel): GameEntity {
        return GameEntity(
            model.title,
            model.thumb,
            model.description,
            model.price
        )
    }
}