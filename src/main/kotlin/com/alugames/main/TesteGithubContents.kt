package com.alugames.main

import com.alugames.services.APIGitHubContentsJSONService

fun main() {
    val service = APIGitHubContentsJSONService()
    val gamers = service.getGamers()
    val games = service.getGames()
    println(games)
    println(gamers)
}