package com.alugames.extensions

import com.alugames.models.GamerModel
import com.alugames.models.InfoGamerJSON

fun InfoGamerJSON.makeGamer(): GamerModel {
    return GamerModel(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}