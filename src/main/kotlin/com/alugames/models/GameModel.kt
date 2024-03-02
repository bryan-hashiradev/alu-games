package com.alugames.models

data class GameModel (val title: String,
                      val thumb: String) {
    var description: String? = null
    var price: Double? = null

    constructor(
        title: String,
        thumb: String,
        description: String,
        price: Double
    ): this(title, thumb) {
        this.description = description
        this.price = price
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