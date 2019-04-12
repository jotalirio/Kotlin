package com.example.kotlin.sets

fun main(args: Array<String>) {

    // Sets are similar to Lists except we can't have duplicate items and we create them in the same way that we create
    // Lists and Maps. We can use the 'setOf' an 'immutableSet' functions

    // Immutable Set
    println()
    println("Immutable Set: ")
    val setInts = setOf(10, 15, 19, 5, 3, -22)
    println(setInts.plus(20))
    println(setInts.plus(10))
    println(setInts.minus(19))
    println(setInts.minus(100)) // Nothing happens
    println(setInts.average())
    println(setInts.drop(3)) // Dropping 3 elements from the beginning


    // Mutable Set
    println()
    println("Mutable Set: ")
    val mutableInts = mutableSetOf(1, 2, 3, 4, 5)
    mutableInts.plus(10) // the 'plus' function does not change the original collection
    println(mutableInts)
}