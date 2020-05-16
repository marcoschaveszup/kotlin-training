package com.example.training.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Virus(
    @Id @GeneratedValue val virusId: Long?,
    val dangerLevel: String,
    @Column(unique = true) val name: String
) {
    constructor(name: String) : this(null, "LOW", name)
}
