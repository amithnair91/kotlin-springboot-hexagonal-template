package com.amithnair.hexagonaltemplate.usecase

import com.amithnair.hexagonaltemplate.domain.Organization
import com.amithnair.hexagonaltemplate.usecase.storage.OrganizationStorage
import io.kotlintest.shouldBe
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.slot
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
            coEvery { organizationStorage.exists(google) } returns true
        }

        @Nested
        inner class AndOrganizationIsCreatedWithValidInputs {
            private val validInput = CreateOrganizationInput(name = google)

            @Test
            fun `should throw organization already exists error`() = runBlocking {
                val exception = assertThrows<Exception> { runBlocking { usecase.invoke(validInput) } }
                exception.message shouldBe "Organization already exists"
                coVerify(exactly = 1) { organizationStorage.exists(google) }
            }
        }
    }

    @Nested
    inner class GivenOrganizationGoogleDoesNotExist {
        private val google = "Google"

        private val organizationStorage: OrganizationStorage = mockk()
        private val usecase = CreateOrganization(organizationStorage)

        @BeforeEach
        fun setup() {
            coEvery { organizationStorage.exists(google) } returns false
            coEvery { organizationStorage.save(any()) } just Runs
        }

        @Nested
        inner class AndOrganizationIsCreatedWithValidInputs {
            private val validInput = CreateOrganizationInput(name = google)

            @Test
            fun `should save organization to storage`() = runBlocking {
                usecase(validInput)

                val organizationSlot = slot<Organization>()
                coVerify(exactly = 1) { organizationStorage.exists(google) }
                coVerify(exactly = 1) { organizationStorage.save(capture(organizationSlot)) }

                val savedOrganization = organizationSlot.captured
                savedOrganization.name shouldBe validInput.name
            }
        }
    }
}