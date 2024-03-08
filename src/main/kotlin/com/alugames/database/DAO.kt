package com.alugames.database

import com.alugames.models.GameModel
import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(
    protected val entityManager: EntityManager,
    protected val entityType: Class<TEntity>
) {
    abstract fun toModel(entity: TEntity): TModel
    abstract fun toEntity(model: TModel): TEntity
    open fun getList(): List<TModel> {
        val query = entityManager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map {
            toModel(it)
        }
    }
    open fun add(model: TModel) {
        entityManager.transaction.begin()
        entityManager.persist(toEntity(model))
        entityManager.transaction.commit()
    }

    open fun remove(id: Int) {
        entityManager.transaction.begin()
        entityManager.remove(getEntityByID(id))
        entityManager.transaction.commit()
    }

    open fun getByID(id: Int): TModel {
        return toModel(getEntityByID(id))
    }

    private fun getEntityByID(id: Int): TEntity {
        val query = entityManager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        return query.singleResult
    }
}