package com.alugames.database

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
        )
    }

    override fun toEntity(model: GamerModel): GamerEntity {
        return GamerEntity(
            model.name,
            model.email,
            model.birthDate,
            model.userName,
        )
    }
}