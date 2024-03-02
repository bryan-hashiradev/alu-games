package com.alugames.models

import java.time.LocalDate
import java.time.Period

class PeriodRent(
    val initialDate: LocalDate,
    val finalDate: LocalDate,
) {
    val days
        get() = Period.between(initialDate, finalDate).days
}