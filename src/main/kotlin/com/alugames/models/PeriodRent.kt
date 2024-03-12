package com.alugames.models

import java.time.LocalDate
import java.time.Period
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable()
class PeriodRent(
    @Column(name = "dataInicial")
    val initialDate: LocalDate = LocalDate.now(),
    @Column(name = "dataFinal")
    val finalDate: LocalDate = LocalDate.now().plusDays(7),
) {
    val days
        get() = Period.between(initialDate, finalDate).days
}