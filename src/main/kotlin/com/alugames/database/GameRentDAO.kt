package com.alugames.database

import com.alugames.extensions.toEntity
import com.alugames.extensions.toModel
import com.alugames.models.GameRentModel
import javax.persistence.EntityManager

class GameRentDAO(manager: EntityManager): DAO<GameRentModel,GameRentEntity>(manager, GameRentEntity::class.java) {
    override fun toModel(entity: GameRentEntity): GameRentModel {
        return GameRentModel(
            entity.gamerEntity.toModel(),
            entity.gameEntity.toModel(),
            entity.periodRent,
        ).apply {
            this.id = entity.id
        }
    }

    override fun toEntity(model: GameRentModel): GameRentEntity {
        return GameRentEntity(
            model.gamer.toEntity(),
            model.game.toEntity(),
            model.periodRent,
        ).apply {
            this.id = model.id
            this.priceRent = model.rentPrice
        }
    }
}