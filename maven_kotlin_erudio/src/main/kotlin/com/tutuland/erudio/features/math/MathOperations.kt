package com.tutuland.erudio.features.math

import com.tutuland.erudio.exceptions.MathOperationException

class MathOperations {

    fun sum(first: String, second: String) = applyCalc(first, second) { a, b ->
        a + b
    }

    fun subtract(first: String, second: String) = applyCalc(first, second) { a, b ->
        a - b
    }

    fun multiply(first: String, second: String) = applyCalc(first, second) { a, b ->
        a * b
    }

    fun divide(first: String, second: String) = applyCalc(first, second) { a, b ->
        if (b == 0.0) throw MathOperationException("Cannot divide by zero")
        a / b
    }

    fun mean(first: String, second: String) = applyCalc(first, second) { a, b ->
        (a + b) / 2
    }

    fun sqrt(number: String) = applyCalc(number) { a ->
        kotlin.math.sqrt(a)
    }

    private fun applyCalc(number: String, calc: (Double) -> Double): Double {
        val a = number.toDouble()
        return calc(a)
    }

    private fun applyCalc(first: String, second: String, calc: (Double, Double) -> Double): Double {
        val a = first.toDouble()
        val b = second.toDouble()
        return calc(a, b)
    }

    private fun String?.toDouble() = this
        ?.replace(",", ".")
        ?.toDoubleOrNull()
        ?: throw MathOperationException("Please set valid numeric values")
}
