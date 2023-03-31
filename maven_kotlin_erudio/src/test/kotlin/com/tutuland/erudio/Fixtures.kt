package com.tutuland.erudio

import com.tutuland.erudio.features.person.data.PersonEntity
import com.tutuland.erudio.features.person.domain.Person
fun mockPerson(number: Int) = Person(
    id = number.toLong(),
    firstName = "FirstName$number",
    lastName = "LastName$number",
    address = "Address$number",
    gender = if (number % 2 == 0) "Male" else "Female",
)

fun mockPersonList(listSize: Int = 14) = buildList { repeat(listSize) { add(mockPerson(it)) } }

fun mockPersonEntity(number: Int) = PersonEntity(
    id = number.toLong(),
    firstName = "FirstName$number",
    lastName = "LastName$number",
    address = "Address$number",
    gender = if (number % 2 == 0) "Male" else "Female",
)

fun mockPersonEntityList(listSize: Int = 14) = buildList { repeat(listSize) { add(mockPersonEntity(it)) } }
