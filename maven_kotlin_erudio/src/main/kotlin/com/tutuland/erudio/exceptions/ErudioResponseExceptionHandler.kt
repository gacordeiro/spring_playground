package com.tutuland.erudio.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@RestController
@ControllerAdvice
class ErudioResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(
        exception: Exception,
        request: WebRequest,
    ): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            details = request.getDescription(false),
            message = exception.message,
        )
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(MathOperationException::class)
    fun handleMathOperationException(
        exception: Exception,
        request: WebRequest,
    ): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            details = request.getDescription(false),
            message = exception.message,
        )
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        exception: Exception,
        request: WebRequest,
    ): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            details = request.getDescription(false),
            message = exception.message,
        )
        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}