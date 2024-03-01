package com.alugames.services

import com.alugames.models.InfoGameAPIShark

class APISharkService: APIServiceContract {
    override val baseURL: String = "https://www.cheapshark.com/api/1.0"

    fun getGameByID(id: String): InfoGameAPIShark {
        val URI = "/games"
        val queryParams = "?id=$id"
        val completeURL = "${this.baseURL}${URI}${queryParams}"
        println(completeURL)
        val response = this.makeRequest(completeURL)

        return gson.fromJson(response.body(), InfoGameAPIShark::class.java)
    }
}