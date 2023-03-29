package com.tutuland.erudio.features.math

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {
    val math = MathOperations()

    @RequestMapping(value = ["/sum/{first}/{second}"])
    fun sum(
        @PathVariable(name = "first") first: String,
        @PathVariable(name = "second") second: String,
    ) = math.sum(first, second)

    @RequestMapping(value = ["/subtract/{first}/{second}"])
    fun subtract(
        @PathVariable(name = "first") first: String,
        @PathVariable(name = "second") second: String,
    ) = math.subtract(first, second)

    @RequestMapping(value = ["/multiply/{first}/{second}"])
    fun multiply(
        @PathVariable(name = "first") first: String,
        @PathVariable(name = "second") second: String,
    ) = math.multiply(first, second)

    @RequestMapping(value = ["/divide/{first}/{second}"])
    fun divide(
        @PathVariable(name = "first") first: String,
        @PathVariable(name = "second") second: String,
    ) = math.divide(first, second)

    @RequestMapping(value = ["/mean/{first}/{second}"])
    fun mean(
        @PathVariable(name = "first") first: String,
        @PathVariable(name = "second") second: String,
    ) = math.mean(first, second)

    @RequestMapping(value = ["/sqrt/{number}"])
    fun sqrt(
        @PathVariable(name = "number") number: String,
    ) = math.sqrt(number)
}