package com.tutuland.erudio.mapping

import com.github.dozermapper.core.DozerBeanMapperBuilder

private val mapper = DozerBeanMapperBuilder.buildDefault()

fun <I, O> I.mapAs(outputClass: Class<O>?): O = mapper.map(this, outputClass)
fun <I, O> List<I>.mapEachAs(outputClass: Class<O>?): List<O> = map { it.mapAs(outputClass) }
