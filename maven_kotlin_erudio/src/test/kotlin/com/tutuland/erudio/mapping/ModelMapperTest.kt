package com.tutuland.erudio.mapping

import com.tutuland.erudio.features.person.data.PersonEntity
import com.tutuland.erudio.features.person.domain.Person
import com.tutuland.erudio.mockPerson
import com.tutuland.erudio.mockPersonEntity
import com.tutuland.erudio.mockPersonEntityList
import com.tutuland.erudio.mockPersonList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ModelMapperTest {
    @Test
    fun `when mapping a single PersonEntity to Person, mapper completes properly`() {
        val input = mockPersonEntity(0)
        val output = input.mapAs(Person::class.java)
        assertEquals(0L, output.id)
        assertEquals("FirstName0", output.firstName)
        assertEquals("Male", output.gender)
    }

    @Test
    fun `when mapping a list of PersonEntity to list of Person, mapper completes properly`() {
        val input = mockPersonEntityList(3)
        val output = input.mapEachAs(Person::class.java)
        assertEquals(0L, output[0].id)
        assertEquals("FirstName0", output[0].firstName)
        assertEquals("Male", output[0].gender)
        assertEquals(1L, output[1].id)
        assertEquals("FirstName1", output[1].firstName)
        assertEquals("Female", output[1].gender)
        assertEquals(2L, output[2].id)
        assertEquals("FirstName2", output[2].firstName)
        assertEquals("Male", output[2].gender)

    }

    @Test
    fun `when mapping a single Person to PersonEntity, mapper completes properly`() {
        val input = mockPerson(0)
        val output = input.mapAs(PersonEntity::class.java)
        assertEquals(0L, output.id)
        assertEquals("FirstName0", output.firstName)
        assertEquals("Male", output.gender)
    }

    @Test
    fun `when mapping a list of Person to list of PersonEntity, mapper completes properly`() {
        val input = mockPersonList(3)
        val output = input.mapEachAs(PersonEntity::class.java)
        assertEquals(0L, output[0].id)
        assertEquals("FirstName0", output[0].firstName)
        assertEquals("Male", output[0].gender)
        assertEquals(1L, output[1].id)
        assertEquals("FirstName1", output[1].firstName)
        assertEquals("Female", output[1].gender)
        assertEquals(2L, output[2].id)
        assertEquals("FirstName2", output[2].firstName)
        assertEquals("Male", output[2].gender)
    }
}
