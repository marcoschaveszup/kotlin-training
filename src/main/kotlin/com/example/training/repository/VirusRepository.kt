package com.example.training.repository

import com.example.training.model.Virus
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VirusRepository : CrudRepository<Virus, Long> {
    fun findByVirusId(id: Long): Virus?
    fun findByName(name: String): Virus?
}