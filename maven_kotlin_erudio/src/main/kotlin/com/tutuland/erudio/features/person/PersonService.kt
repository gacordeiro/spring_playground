package com.tutuland.erudio.features.person

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    private val counter = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people.")
        val people = mutableListOf<Person>()
        repeat(7) { people.add(getMock()) }
        return people
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person.")
        return getMock()
    }

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) = Unit

    fun getMock(): Person {
        return Person(
            id = counter.incrementAndGet(),
            firstName = "Guilherme",
            lastName = "Cordeiro",
            address = "Tutulandia - São Paulo - Brasil",
            gender = "Male",
        )
    }
}