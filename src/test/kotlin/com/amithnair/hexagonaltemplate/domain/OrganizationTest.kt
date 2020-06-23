package com.amithnair.hexagonaltemplate.domain

import com.amithnair.hexagonaltemplate.builders.OrganizationBuilder
import org.junit.jupiter.api.Test
import io.kotlintest.shouldBe

class OrganizationTest {

    @Test
    fun `fails if organization name is empty`() {
        val organizationName = "Microsoft"
        Organization(name = organizationName) shouldBe OrganizationBuilder(name = organizationName).build()
    }

}