package org.araqnid.typevariance.kotlin

import org.araqnid.typevariance.BasicEvent
import org.araqnid.typevariance.Event

interface InvariantEventDeserializer<E> {
    fun deserialize(bytes: ByteArray): E
}

val invariantEventDeserializer: InvariantEventDeserializer<out Event> = object : InvariantEventDeserializer<Event> {
    override fun deserialize(bytes: ByteArray): Event = TODO()
}

val invariantBasicEventDeserializer: InvariantEventDeserializer<out Event> = object : InvariantEventDeserializer<BasicEvent> {
    override fun deserialize(bytes: ByteArray): BasicEvent = TODO()
}
