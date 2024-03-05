package com.alugames.extensions

fun Int.isNoteValid(): Boolean {
    return if (this in 1..10) {
        true
    } else {
        println("Não foi posssível avaliar: Nota $this inválida")
        false
    }
}