package com.amithnair.hexagonaltemplate.usecase.storage

import com.amithnair.hexagonaltemplate.domain.Organization

interface OrganizationStorage {
    suspend fun exists(name: String): Boolean
    suspend fun save(google: Organization)
}
