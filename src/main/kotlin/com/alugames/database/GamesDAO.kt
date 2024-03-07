package com.alugames.database

import com.alugames.database.Database.getConnection
import com.alugames.models.GameModel
import javax.xml.crypto.Data

class GamesDAO {
    fun getGames(): List<GameModel> {
        val entityManager = Database.getEntityMananger()
        return try {
            val query = entityManager.createQuery("FROM GameEntity", GameEntity::class.java)
            query.resultList.map {
                GameModel(
                    it.title,
                    it.thumb,
                    it.description,
                    it.price,
                    it.id
                )
            }
        } finally {
            entityManager.close()
        }
    }
//Utilizacao do jdbc na busca e na insercao de dados na base relacional
//    fun getGames(): List<GameModel> {
//        val gameList = mutableListOf<GameModel>()
//        val conn = getConnection()
//
//        if (conn != null) {
//            try {
//                val stmt = conn.createStatement()
//                val res = stmt.executeQuery("SELECT * FROM jogos")
//
//                while (res.next()) {
////                    val id = resultado.getInt("id")
//                    val title = res.getString("titulo")
//                    val thumb = res.getString("capa")
//                    val description = res.getString("descricao")
//                    val price = res.getBigDecimal("preco")
//
//                    val game = GameModel(title, thumb, description, price)
//                    gameList.add(game)
//                }
//
//                stmt.close()
//            } finally {
//                conn.close()
//            }
//        }
//
//        return gameList
//    }
//
//    fun insertGame(game: GameModel) {
//        val conn = getConnection()
//        val insert = "INSERT INTO jogos (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
//
//        if (conn != null) {
//            try {
//                val stmt = conn.prepareStatement(insert)
//                stmt.setString(1, game.title)
//                stmt.setString(2, game.thumb)
//                stmt.setBigDecimal(3, game.price)
//                stmt.setString(4, game.description)
//
//                stmt.executeUpdate()
//
//                stmt.close()
//
//            } finally {
//                conn.close()
//            }
//        }
//    }
}