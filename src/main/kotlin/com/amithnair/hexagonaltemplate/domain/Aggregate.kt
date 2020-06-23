package com.amithnair.hexagonaltemplate.domain

import java.util.Date

abstract class Aggregate<ID>(
    var created: Date = Date(),
    var updated: Date = Date()
) {
    abstract val id: ID
    fun id() = id.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return id == (other as Aggregate<*>).id
    }

    override fun hashCode() = id.hashCode()
}
