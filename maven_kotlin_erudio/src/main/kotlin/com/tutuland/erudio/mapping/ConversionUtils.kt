package com.tutuland.erudio.mapping

import com.tutuland.erudio.exceptions.MathOperationException

fun String?.asDouble() = this
    ?.replace(",", ".")
    ?.toDoubleOrNull()
    ?: throw MathOperationException("Please set valid numeric values")
