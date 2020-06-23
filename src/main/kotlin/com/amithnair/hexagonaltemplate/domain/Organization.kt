package com.amithnair.hexagonaltemplate.domain

data class Organization private constructor(val name: String) {
    companion object {
        operator fun invoke(name: String): Organization {
            require(!name.isNullOrBlank()) { "Organization name cannot be empty" }
            return Organization(name = name)
        }
    }
}




