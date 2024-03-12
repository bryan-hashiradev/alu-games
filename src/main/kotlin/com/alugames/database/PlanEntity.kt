package com.alugames.database

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    @Column(name = "tipo")
    val type: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
)

@Entity
@DiscriminatorValue(value = "default")
class PlanDefaultEntity(type: String = "default", id: Int = 0) : PlanEntity(type, id)

@Entity
@DiscriminatorValue(value = "subscribe")
class PlanSubscribeEntity(
    type: String = "subscribe",
    @Column(name = "jogosIncluidos")
    val gamesIncluded: Int = 0,
    @Column(name = "mensalidade")
    val fees: BigDecimal = BigDecimal(0.0),
    @Column(name = "percentualDeDesconto")
    val discountPercentage: BigDecimal = BigDecimal(0.0),
    id: Int = 0,
) : PlanEntity(type, id)