package com.amithnair.hexagonaltemplate.usecase

import com.amithnair.hexagonaltemplate.domain.Organization
import com.amithnair.hexagonaltemplate.usecase.storage.OrganizationStorage

class CreateOrganization(private val organizationStorage: OrganizationStorage) {
    suspend operator fun invoke(input: CreateOrganizationInput) {
        require(!organizationStorage.exists(input.name)) { "Organization already exists" }
        organizationStorage.save(Organization(name = input.name))
    }
}

data class CreateOrganizationInput(val name: String)
