package com.amithnair.hexagonaltemplate.domain

import java.util.UUID

data class Organization private constructor(override val id: UUID, val name: String) : Aggregate<UUID>() {

    companion object {
        operator fun invoke(name: String?): Organization {
            require(!name.isNullOrBlank()) { "Organization name cannot be null or empty" }
            return Organization(id = UUID.randomUUID(), name = name)
        }
    }
}
