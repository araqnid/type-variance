package org.araqnid.typevariance.scala

import java.time.Instant.EPOCH
import java.time.temporal.Temporal

object Arrays {
  val ints: Array[Int] = Array(1, 2, 3)
  val any: Array[Any] = Array("", "", "")
  copy(ints, any) // Error without "_ <: Any"

  fill[Temporal](Array[Temporal](null, null), EPOCH)

  def copy(from: Array[_ <: Any], to: Array[Any]): Unit = {
    assert(from.length == to.length)
    from.indices.foreach { i =>
      to(i) = from(i)
    }
  }

  def fill[T](dest: Array[T], value: T): Unit = {
    dest.indices.foreach { i =>
      dest(i) = value
    }
  }
}
