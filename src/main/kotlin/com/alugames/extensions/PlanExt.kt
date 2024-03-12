package com.alugames.extensions

import com.alugames.database.PlanDefaultEntity
import com.alugames.database.PlanEntity
import com.alugames.database.PlanSubscribeEntity
import com.alugames.models.PlanDefaultModel
import com.alugames.models.PlanModel
import com.alugames.models.PlanSubscribeModel

fun PlanEntity.toModel(): PlanModel {
    return when (this) {
        is PlanDefaultEntity -> PlanDefaultModel(this.type, this.id)
        is PlanSubscribeEntity -> PlanSubscribeModel(
            this.type,
            this.gamesIncluded,
            this.fees,
            this.discountPercentage,
            this.id
        )
    }
}

fun PlanModel.toEntity(): PlanEntity {
    return when (this) {
        is PlanDefaultModel -> PlanDefaultEntity(this.type)
        is PlanSubscribeModel -> PlanSubscribeEntity(
            this.type,
            this.gamesIncluded,
            this.fees,
            this.discountPercentage,
        )
    }
}