package com.alugames.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import javax.persistence.EntityManager
import javax.persistence.Persistence

object Database {
    fun getEntityMananger(): EntityManager {
        val factory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }
}