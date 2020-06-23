package com.amithnair.hexagonaltemplate.usecase.storage

interface OrganizationStorage {
    fun exists(name: String): Boolean
}
