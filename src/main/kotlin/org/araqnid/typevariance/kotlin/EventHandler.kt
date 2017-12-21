package org.araqnid.typevariance.kotlin

import org.araqnid.typevariance.BasicEvent
import org.araqnid.typevariance.Event
import java.time.Instant

interface EventHandler<in E> {
    fun accept(event: E, timestamp: Instant)
}

val eventHandler: EventHandler<BasicEvent> = object : EventHandler<Event> {
    override fun accept(event: Event, timestamp: Instant) = TODO()
}

val basicEventHandler: EventHandler<BasicEvent> = object : EventHandler<BasicEvent> {
    override fun accept(event: BasicEvent, timestamp: Instant) = TODO()
}

// val invalid: EventHandler<Event> = basicEventHandler

inline fun <reified E : Event> downcast(underlying : EventHandler<E>) : EventHandler<Event> {
    return object : EventHandler<Event> {
        override fun accept(event: Event, timestamp: Instant) {
            underlying.accept(event as E, timestamp)
        }
    }
}

val runtimeSafety: EventHandler<Event> = downcast(basicEventHandler)
