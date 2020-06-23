package com.amithnair.hexagonaltemplate.domain

import com.amithnair.hexagonaltemplate.builders.OrganizationBuilder
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OrganizationTest {

    @Test
    fun `fails if organization name is empty`() {
        val exception = assertThrows<Exception> { Organization(name = "") }
        exception.message shouldBe "Organization name cannot be empty"
    }

    @Test
    fun `creats organization with valid inputs`(){
        val organizationName = "Microsoft"
        Organization(name = organizationName) shouldBe OrganizationBuilder(name = organizationName).build()
    }

}