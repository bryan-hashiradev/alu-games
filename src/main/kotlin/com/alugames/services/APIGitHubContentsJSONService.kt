package com.alugames.services

import com.alugames.extensions.makeGame
import com.alugames.extensions.makeGamer
import com.alugames.models.GameModel
import com.alugames.models.GamerModel
import com.alugames.models.InfoGameJSON
import com.alugames.models.InfoGamerJSON
import com.google.gson.reflect.TypeToken

class APIGitHubContentsJSONService: APIServiceContract {
    override val baseURL = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main"

    fun getGamers(): List<GamerModel> {
        val URI = "/gamers.json"
        val completeURL = "$baseURL$URI"
        println(completeURL)
        val typeInfoGamer = object : TypeToken<List<InfoGamerJSON>>() {}.type
        val response = makeRequest(completeURL)
        val infoGamerList: List<InfoGamerJSON> = gson.fromJson(response.body(), typeInfoGamer)

        return infoGamerList.map {
            it.makeGamer()
        }
    }

    fun getGames(): List<GameModel> {
        val URI = "/jogos.json"
        val completeURL = "$baseURL$URI"
        println(completeURL)
        val typeInfoGame = object : TypeToken<List<InfoGameJSON>>() {}.type
        val response = makeRequest(completeURL)
        val infoGamerList: List<InfoGameJSON> = gson.fromJson(response.body(), typeInfoGame)

        return infoGamerList.map {
            it.makeGame()
        }
    }
}