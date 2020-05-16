package com.example.training.controller

import com.example.training.model.Virus
import com.example.training.service.VirusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class VirusController {

    @Autowired
    lateinit var virusService: VirusService

    @GetMapping("/virus/{virusId}")
    fun getVirus(@PathVariable virusId: Long): Virus? {
        return virusService.getVirus(virusId)
    }

    @PostMapping("/virus")
    fun createVirus(@RequestBody virus: Virus): Virus {
        return virusService.saveVirus(virus)
    }

    @PutMapping("/virus")
    fun updateVirus(@RequestBody virus: Virus): Virus {
        return virusService.updateVirus(virus)
    }

    @DeleteMapping("/virus/{virusId}")
    fun deleteVirus(@PathVariable virusId: Long) {
        virusService.removeVirus(virusId)
    }
}