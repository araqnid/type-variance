package org.araqnid.typevariance.kotlin

import java.time.Instant.EPOCH
import java.time.temporal.Temporal

fun main(args: Array<String>) {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    copy(ints, any) // Error without "out": expects (Array<Any>, Array<Any>)

    fill<Temporal>(arrayOfNulls(2), EPOCH) // Error without "in": expects Array<Temporal>, not Array<Temporal?>
}

fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

fun <T> fill(dest: Array<in T>, value: T) {
    for (i in dest.indices)
        dest[i] = value
}
