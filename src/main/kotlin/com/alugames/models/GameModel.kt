package com.alugames.models

data class GameModel (
    val title: String,
    val thumb: String,
    ): Recommended {
    private val notes = mutableListOf<Int>()
    var description: String? = null
    var price: Double? = null
    override val media: Double
        get() = notes.average()


    constructor(
        title: String,
        thumb: String,
        description: String,
        price: Double
    ): this(title, thumb) {
        this.description = description
        this.price = price
    }

    override fun recommend(note: Int) {
        TODO("Not yet implemented")
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