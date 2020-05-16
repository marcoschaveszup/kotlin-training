package com.example.training.handler

import com.example.training.exception.ErrorDetails
import com.example.training.exception.VirusAlreadyExistsException
import com.example.training.exception.VirusNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [VirusAlreadyExistsException::class])
    fun virusAlreadyExists(ex: VirusAlreadyExistsException): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(ex.message!!)
        return ResponseEntity(errorDetails, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(value = [VirusNotFoundException::class])
    fun virusAlreadyExists(ex: VirusNotFoundException): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(ex.message!!)
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

}