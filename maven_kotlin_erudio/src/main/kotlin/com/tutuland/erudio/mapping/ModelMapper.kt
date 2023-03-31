package com.tutuland.erudio.mapping

import org.modelmapper.ModelMapper

private val mapper = ModelMapper()

fun <I, O> I.mapAs(outputClass: Class<O>?): O = mapper.map(this, outputClass)
fun <I, O> List<I>.mapEachAs(outputClass: Class<O>?): List<O> = map { it.mapAs(outputClass) }
