package com.amithnair.hexagonaltemplate.domain

import io.kotlintest.matchers.numerics.shouldBeGreaterThan
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OrganizationTest {

    @Test
    fun `creates organization with valid inputs`(){
        val organizationName = "Microsoft"
        val organization = Organization(name = organizationName)
        organization.name shouldBe organizationName
        organization.id().length shouldBeGreaterThan 0
    }

    @Test
    fun `fails if organization name is empty`() {
        val exception = assertThrows<Exception> { Organization(name = "") }
        exception.message shouldBe "Organization name cannot be null or empty"
    }

    @Test
    fun `fails to create organization if name is null`(){
        val exception = assertThrows<Exception> { Organization(name = null) }
        exception.message shouldBe "Organization name cannot be null or empty"
    }

}