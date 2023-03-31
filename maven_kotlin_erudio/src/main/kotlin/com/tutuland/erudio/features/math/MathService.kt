package com.tutuland.erudio.features.math

import com.tutuland.erudio.exceptions.MathOperationException
import com.tutuland.erudio.mapping.asDouble
import org.springframework.stereotype.Service

@Service
class MathService {

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
        val a = number.asDouble()
        return calc(a)
    }

    private fun applyCalc(first: String, second: String, calc: (Double, Double) -> Double): Double {
        val a = first.asDouble()
        val b = second.asDouble()
        return calc(a, b)
    }
}
