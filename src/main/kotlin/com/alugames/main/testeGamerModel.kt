package com.alugames.main

import com.alugames.models.GamerModel

fun main() {
//    val gamer1 = GamerModel("bryan", "teste@email.com")
    val gamer1 = GamerModel("bryan", "teste@email.com", "29-12-1998", "hashira")
    val gamer2 = GamerModel("brutos", "bile@brutos.com")


    println(gamer1)
    println(gamer2)

    gamer2.userName = "ReiNewCangaço"

    println(gamer2)

    val gamer3 = GamerModel("tonho", "eu@email.com")

    println(gamer3)

}