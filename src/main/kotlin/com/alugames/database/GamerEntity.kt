package com.alugames.database

import javax.persistence.*

@Entity
@Table(name = "jogador")
data class GamerEntity(
    @Column(name = "nome")
    val name: String = "default name",
    val email: String = "default email",
    @Column(name = "dataNascimento")
    val birthDate: String? = "default birth",
    @Column(name = "nomeUsuario")
    val userName: String? = "default username",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "id_plano")
    val plan: PlanEntity = PlanDefaultEntity(),
)
