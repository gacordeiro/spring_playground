package com.tutuland.erudio.features.person.data

import com.tutuland.erudio.exceptions.ResourceNotFoundException
import com.tutuland.erudio.features.person.PersonRepository
import com.tutuland.erudio.features.person.domain.Person
import com.tutuland.erudio.mapping.mapAs
import com.tutuland.erudio.mapping.mapEachAs
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people.")
        return repository.findAll()
            .mapEachAs(Person::class.java)
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person.")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records for ID: $id") }
            .mapAs(Person::class.java)
    }

    fun create(person: Person): Person {
        logger.info("Creating person: ${person.firstName}")
        val entity = person.mapAs(PersonEntity::class.java)
        return repository.save(entity)
            .mapAs(Person::class.java)
    }

    fun update(person: Person): Person {
        val id = person.id
        logger.info("Updating person with ID: $id")
        val entity = repository.findById(id).orElseThrow { ResourceNotFoundException("No records for ID: $id") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
            .mapAs(Person::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting person with ID: $id")
        val entity = repository.findById(id).orElseThrow { ResourceNotFoundException("No records for ID: $id") }
        repository.delete(entity)
    }
}