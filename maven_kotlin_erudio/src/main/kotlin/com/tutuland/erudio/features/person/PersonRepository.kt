package com.tutuland.erudio.features.person

import com.tutuland.erudio.features.person.data.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<PersonEntity, Long?>
