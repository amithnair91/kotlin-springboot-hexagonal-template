package com.amithnair.hexagonaltemplate.builders

import com.amithnair.hexagonaltemplate.domain.Organization

data class OrganizationBuilder(val name: String = "Google") {
    fun build(): Organization {
        return Organization(name = name)
    }
}