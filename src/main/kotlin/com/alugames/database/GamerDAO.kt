package com.alugames.database

import com.alugames.extensions.toEntity
import com.alugames.extensions.toModel
import com.alugames.models.GamerModel
import javax.persistence.EntityManager

class GamerDAO(entityManager: EntityManager): DAO<GamerModel, GamerEntity>(entityManager, GamerEntity::class.java) {
    override fun toModel(entity: GamerEntity): GamerModel {
        return GamerModel(
            entity.name,
            entity.email,
            entity.birthDate,
            entity.userName,
            entity.id,
        ).apply { this.plan = entity.plan.toModel() }
    }

    override fun toEntity(model: GamerModel): GamerEntity {
        return GamerEntity(
            model.name,
            model.email,
            model.birthDate,
            model.userName,
            model.id,
            model.plan.toEntity()
        )
    }
}