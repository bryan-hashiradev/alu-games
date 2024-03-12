package com.alugames.extensions

import com.alugames.database.GameEntity
import com.alugames.models.GameModel

fun GameEntity.toModel(): GameModel {
    return GameModel(
        this.title,
        this.thumb,
        this.description,
        this.price,
        this.id
    )
}

fun GameModel.toEntity(): GameEntity {
    return GameEntity(
        this.title,
        this.thumb,
        this.description,
        this.price,
        this.id
    )
}