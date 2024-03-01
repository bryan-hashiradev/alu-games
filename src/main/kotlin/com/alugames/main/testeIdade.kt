package com.alugames.main

import com.alugames.models.GamerModel
import java.util.Scanner

fun main () {
    val scanner = Scanner(System.`in`)
    val gamer1 = GamerModel(
        "bryan",
        "bryan@gmail.com",
        "29/12/1998",
        "hashira"
    )

    println(gamer1)
    val gamer = GamerModel.criarGamer(scanner)

    println(gamer)
}