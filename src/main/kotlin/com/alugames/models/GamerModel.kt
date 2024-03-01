package com.alugames.models

import com.alugames.main.getUserInput
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random

data class GamerModel(val name: String, val email: String) {
    private var birthDate: String? = null
    var userName: String? = null
        set(value) {
            if (value.isNullOrBlank()) throw IllegalArgumentException("Nickname inválido!")
            field = value
            if(this.tagUser.isNullOrBlank()) this.generateIDUser()
        }
    var tagUser: String? = null
        private set

    val historySearch: MutableList<GameModel> = mutableListOf<GameModel>()

    constructor(name: String, email: String, birthDate: String, userName: String) : this(name, email) {
        this.userName = userName
        this.birthDate = birthDate
    }

    init {
        if (name.isBlank()) throw IllegalArgumentException("Nome inválido!")
        validateEmail()
    }

    private fun generateIDUser() {
        val tagNumber = Random.nextInt(10000)
        tagUser = String.format("%s#%04d", userName, tagNumber)
    }

    private fun validateEmail() {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (!regex.matches(email)) {
            throw IllegalArgumentException("E-mail inválido!")
        }
    }

    fun getAge(): Int? {
        if (birthDate.isNullOrBlank()) {
            return null
        }
        val date = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"))

        return Period.between(date, LocalDate.now()).years
    }

    override fun toString(): String {
        val age = getAge() ?: "Sem idade informada"
        return """
            ------------------------------------
            NOME: $name
            DATA-NASCIMENTO: $birthDate
            IDADE: $age
            E-MAIL: $email
            TAG: $tagUser
            NICK: $userName
            ------------------------------------
        """.trimIndent()
    }

    companion object {
        fun criarGamer(scanner: Scanner): GamerModel {
            val name = getUserInput("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome: ", scanner)
            val email = getUserInput("Digite seu e-mail: ", scanner)
            val choice = getUserInput("Deseja completar seu cadastro com usuário e data de nascimento? (S/N) ", scanner)

            if (choice.equals("s", true)) {
                val birthDate = getUserInput("Digite sua data de nascimento(DD/MM/AAAA): ", scanner)
                val userName = getUserInput("Digite seu nome de usuário: ", scanner)

                return GamerModel(name, email, birthDate, userName)
            } else {
                return GamerModel (name, email)
            }
        }
    }
}
