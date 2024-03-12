package com.alugames.extensions

import com.alugames.database.GamerEntity
import com.alugames.models.GamerModel

fun GamerEntity.toModel(): GamerModel {
    return GamerModel(
        this.name,
        this.email,
        this.birthDate,
        this.userName,
        this.id
    )
}

fun GamerModel.toEntity(): GamerEntity {
    return GamerEntity(
        this.name,
        this.email,
        this.birthDate,
        this.userName,
        this.id
    )
}