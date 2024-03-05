package com.alugames.extensions

import com.alugames.models.GameModel
import com.alugames.models.InfoGameJSON

fun InfoGameJSON.makeGame(): GameModel {
    return GameModel(
        this.titulo,
        this.capa,
        this.descricao,
        this.preco.toBigDecimal()
    )
}