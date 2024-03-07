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

    //um exemplo de como conseguir uma conexao para realizar o acesso de uma base de dados relacional utilizando o jdbc
    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "bryan", "Dovakin@3711")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}