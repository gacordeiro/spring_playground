package com.tutuland.erudio.features.person

import com.tutuland.erudio.exceptions.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository
    private val counter = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people.")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person.")
        return repository.findById(id).orElseThrow { ResourceNotFoundException("No records for ID: $id") }
    }

    fun create(entity: Person): Person {
        logger.info("Creating person: ${entity.firstName}")
        return repository.save(entity)
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
    }

    fun delete(id: Long) {
        logger.info("Deleting person with ID: $id")
        val entity = repository.findById(id).orElseThrow { ResourceNotFoundException("No records for ID: $id") }
        repository.delete(entity)
    }
}