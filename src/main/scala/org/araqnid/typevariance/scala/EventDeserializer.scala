package org.araqnid.typevariance.scala

import org.araqnid.typevariance.{BasicEvent, Event}

trait EventDeserializer[+E] {
  def deserialize(bytes: Array[Byte]): E
}

object EventDeserializers {
  val eventDeserializer: EventDeserializer[Event] = new EventDeserializer[Event] {
    override def deserialize(bytes: Array[Byte]): Event = ???
  }

  val basicEventDeserializer: EventDeserializer[Event] = new EventDeserializer[BasicEvent] {
    override def deserialize(bytes: Array[Byte]): BasicEvent = ???
  }

  // val invalid: EventDeserializer[BasicEvent] = eventDeserializer
}
