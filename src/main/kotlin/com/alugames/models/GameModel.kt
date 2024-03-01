package com.alugames.models

data class GameModel (val title: String,
                      val thumb: String) {
    var description: String? = null

    constructor(title: String, thumb: String, description:String) : this(title, thumb) {
        this.description = description
    }

    override fun toString(): String {
        return """
            TITULO: ${this.title}
            CAPA: ${this.thumb}
            DESCRIÇÃO: ${this.description}
        """.trimIndent()
    }
}