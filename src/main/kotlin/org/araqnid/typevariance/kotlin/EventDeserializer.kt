package org.araqnid.typevariance.kotlin

import org.araqnid.typevariance.BasicEvent
import org.araqnid.typevariance.Event

interface EventDeserializer<out E> {
    fun deserialize(bytes: ByteArray): E
}

val eventDeserializer: EventDeserializer<Event> = object : EventDeserializer<Event> {
    override fun deserialize(bytes: ByteArray): Event = TODO()
}

val basicEventDeserializer: EventDeserializer<Event> = object : EventDeserializer<BasicEvent> {
    override fun deserialize(bytes: ByteArray): BasicEvent = TODO()
}

// val invalid: EventDeserializer<BasicEvent> = eventDeserializer
