package com.example.training.service.impl

import com.example.training.exception.VirusAlreadyExistsException
import com.example.training.exception.VirusNotFoundException
import com.example.training.model.Virus
import com.example.training.repository.VirusRepository
import com.example.training.service.VirusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VirusServiceImpl : VirusService {

    @Autowired
    lateinit var virusRepository: VirusRepository


    override fun saveVirus(virus: Virus): Virus {
        if (virusRepository.findByName(virus.name) != null) throw VirusAlreadyExistsException(virusAlreadyExists)
        return virusRepository.save(virus)
    }

    override fun getVirus(virusId: Long): Virus? {
        return virusRepository.findByVirusId(virusId) ?: throw VirusNotFoundException(virusNotFound)
    }

    override fun removeVirus(virusId: Long) {
        virusRepository.findByVirusId(virusId) ?: throw VirusNotFoundException(virusNotFound)

        virusRepository.deleteById(virusId)
    }

    override fun updateVirus(virus: Virus): Virus {
        val foundVirus = virusRepository.findByName(virus.name) ?: throw VirusNotFoundException(virusNotFound)
        return virusRepository.save(virus.copy(virusId = foundVirus.virusId))
    }

    companion object {
        const val virusNotFound = "Virus not found!"
        const val virusAlreadyExists = "Virus already registered!"
    }
}