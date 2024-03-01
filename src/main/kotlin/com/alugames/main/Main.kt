package com.alugames.main

import com.alugames.models.GameModel
import com.alugames.models.GamerModel
import com.alugames.services.APISharkService
import java.util.*


fun main() {
    var newGame: GameModel? = null
    val scanner = Scanner(System.`in`)
    var userInput: String?
    userInput = null

    val gamer = GamerModel.criarGamer(scanner)

    do {
        userInput = getUserInput("Informe o ID de um Jogo: ", scanner)

        val apiSharkService = APISharkService()

        val result = runCatching {
            println(userInput)

            val newGameData = apiSharkService.getGameByID(userInput!!)
            println(newGameData)
            newGame = GameModel(
                newGameData.info.title,
                newGameData.info.thumb
            )
        }

        result.onSuccess {
            userInput = getUserInput("Deseja inserir uma descrição? s/n: ", scanner)
            if (userInput.equals("s", true)) {
                val userDescription = getUserInput(
                    "Digite a descrição: ",
                    scanner,
                )
                newGame?.description = userDescription
            } else {
                newGame?.description = newGame?.title
            }
        }
        result.onSuccess {
            gamer.historySearch.add(newGame!!)
            println(newGame)
        }
        result.onFailure {
            println("404 Jogo não encontrado!")
        }
        userInput = null

    } while (continueRunning(scanner))
    println("Fim das pesquisas!")
    println("Jogos Pesquisados ${gamer.tagUser}")
    gamer.historySearch.forEach { game -> println(game) }
}

fun getUserInput(msg: String = "Esperando Input: ", scanner: Scanner): String {
    print(msg)
    return scanner.nextLine()
}

fun continueRunning (scanner: Scanner): Boolean {
    val next = getUserInput("Realizar nova pesquisa? s/n: ", scanner)
    return next.equals("s", true)
}