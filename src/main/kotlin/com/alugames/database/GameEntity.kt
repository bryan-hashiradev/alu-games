package com.alugames.database

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "jogos")
data class GameEntity(
    @Column(name = "titulo")
    val title: String = "Title",
    @Column(name = "capa")
    val thumb: String = "thumb",
    @Column(name = "descricao")
    val description: String? = "description",
    @Column(name = "preco")
    val price: BigDecimal? = BigDecimal(0.0),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
)
