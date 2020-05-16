package com.example.training.service

import com.example.training.model.Virus

interface VirusService {
    fun saveVirus(virus: Virus): Virus
    fun getVirus(virusId: Long): Virus?
    fun removeVirus(virusId: Long)
    fun updateVirus(virus: Virus): Virus
}