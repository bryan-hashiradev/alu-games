package com.alugames.models

import com.alugames.extensions.isNoteValid
import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.math.RoundingMode

data class GameModel (
    @Expose val title: String,
    @Expose val thumb: String,
    ): Recommended {
    private val notes = mutableListOf<Int>()
    var description: String? = null
    var price: BigDecimal? = null
    override val media: BigDecimal
        get() = notes.average().toBigDecimal().setScale(2, RoundingMode.HALF_EVEN)


    constructor(
        title: String,
        thumb: String,
        description: String,
        price: BigDecimal
    ): this(title, thumb) {
        this.description = description
        this.price = price
    }

    override fun recommend(note: Int) {
        if (note.isNoteValid()) notes.add(note)
    }

    override fun toString(): String {
        return """
            TITULO: ${this.title}
            CAPA: ${this.thumb}
            DESCRIÇÃO: ${this.description}
            PREÇO: ${this.price}
        """.trimIndent()
    }
}