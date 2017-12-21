package org.araqnid.typevariance.scala

import java.time.Instant

import org.araqnid.typevariance.{BasicEvent, Event}

import scala.reflect.ClassTag

trait EventHandler[-E] {
  def accept(event: E, timestamp: Instant)
}

object EventHandlers {
  val eventHandler: EventHandler[BasicEvent] = new EventHandler[Event] {
    override def accept(event: Event, timestamp: Instant): Unit = ???
  }

  val basicEventHandler: EventHandler[BasicEvent] = new EventHandler[BasicEvent] {
    override def accept(event: BasicEvent, timestamp: Instant): Unit = ???
  }

  // val invalid: EventHandler[Event] = basicEventHandler

  def downcast[E <: Event : ClassTag](underlying: EventHandler[E]): EventHandler[Event] = {
    new EventHandler[Event] {
      override def accept(event: Event, timestamp: Instant): Unit = {
        underlying.accept(implicitly[ClassTag[E]].runtimeClass.cast(event).asInstanceOf[E], timestamp)
      }
    }
  }

  val runtimeSafety: EventHandler[Event] = downcast(basicEventHandler)
}
