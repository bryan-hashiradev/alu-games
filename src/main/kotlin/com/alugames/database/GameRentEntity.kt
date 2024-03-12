package com.alugames.database

import com.alugames.models.PeriodRent
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "aluguel")
class GameRentEntity(
    @ManyToOne
    @JoinColumn(name = "jogador_id")
    val gamerEntity:GamerEntity = GamerEntity(),
    @ManyToOne
    @JoinColumn(name = "jogo_id")
    val gameEntity:GameEntity = GameEntity(),
    @Embedded
    val periodRent: PeriodRent = PeriodRent()
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    @Column(name = "precoAluguel")
    var priceRent: BigDecimal = BigDecimal(0)
}