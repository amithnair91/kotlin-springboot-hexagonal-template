package com.amithnair.hexagonaltemplate.domain

import java.util.UUID

data class Organization private constructor(val id: UUID, val name: String) {

    companion object {
        operator fun invoke(name: String?): Organization {
            require(!name.isNullOrBlank()) { "Organization name cannot be null or empty" }
            return Organization(id = UUID.randomUUID(), name = name)
        }
    }

    fun id(): String {
        return id.toString()
    }
}
