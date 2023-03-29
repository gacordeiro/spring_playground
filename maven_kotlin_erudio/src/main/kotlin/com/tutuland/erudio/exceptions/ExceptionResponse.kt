package com.tutuland.erudio.exceptions

import java.util.*

data class ExceptionResponse(
    val timestamp: Date,
    val details: String,
    val message: String? = null,
)
