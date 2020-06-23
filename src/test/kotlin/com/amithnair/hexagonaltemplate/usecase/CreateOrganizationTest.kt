package com.amithnair.hexagonaltemplate.usecase

import com.amithnair.hexagonaltemplate.usecase.storage.OrganizationStorage
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.lang.Exception
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CreateOrganizationTest {

    @Nested
    inner class GivenOrganizationGoogleExists {

        private val google = "Google"
        private val organizationStorage: OrganizationStorage = mockk()
        private val usecase = CreateOrganization(organizationStorage)

        @BeforeEach
        fun setup() {
            every { organizationStorage.exists(google) } returns true
        }

        @Nested
        inner class AndOrganizationIsCreatedWithValidInputs {
            private val validInput = CreateOrganizationInput(name = google)

            @Test
            fun `should throw organization already exists error`() = runBlocking {
                val exception = assertThrows<Exception> { runBlocking { usecase.invoke(validInput) } }
                exception.message shouldBe "Organization already exists"
            }
        }
    }
}
