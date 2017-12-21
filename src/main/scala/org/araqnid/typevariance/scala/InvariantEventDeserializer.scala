package org.araqnid.typevariance.scala

import org.araqnid.typevariance.{BasicEvent, Event}

trait InvariantEventDeserializer[E] {
  def deserialize(bytes: Array[Byte]): E
}

object InvariantDeserializers {
  val invariantEventDeserializer: InvariantEventDeserializer[_ <: Event] = new InvariantEventDeserializer[Event] {
    override def deserialize(bytes: Array[Byte]): Event = ???
  }

  val invariantBasicEventDeserializer: InvariantEventDeserializer[_ <: Event] = new InvariantEventDeserializer[BasicEvent] {
    override def deserialize(bytes: Array[Byte]): BasicEvent = ???
  }
}
