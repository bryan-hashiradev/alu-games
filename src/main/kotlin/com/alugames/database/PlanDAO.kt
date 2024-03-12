package com.alugames.database

import com.alugames.extensions.toEntity
import com.alugames.extensions.toModel
import com.alugames.models.PlanDefaultModel
import com.alugames.models.PlanModel
import com.alugames.models.PlanSubscribeModel
import javax.persistence.EntityManager

class PlanDAO(entityManager: EntityManager) : DAO<PlanModel, PlanEntity>(entityManager, PlanEntity::class.java) {
    override fun toModel(entity: PlanEntity): PlanModel {
        return entity.toModel()
    }

    override fun toEntity(model: PlanModel): PlanEntity {
        return model.toEntity()
    }
}