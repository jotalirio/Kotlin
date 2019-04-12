package com.example.kotlin.lists


fun main(args: Array<String>) {

    // Some functions that Kotlin has added to manipulate lists. Some functions work directly on the list and others return
    // a new list

    val strings = listOf("winter", "spring", "summer", "summer", "fall")
    val colorList = listOf("black", "white", "red", "black", "red")

    // Mutable list
    val mutableSeasons = strings.toMutableList()
    mutableSeasons.add("some other season")
    println(mutableSeasons)


    // Get the first and last element in a list
    println()
    println("First element: " + strings.first())
    println("Last element: " + strings.last())

    // Reverse
    println()
    println("Reverse: ")
    println(strings.asReversed())

    // getOrNull()
/*    if (strings.size > 5) {
        println(strings[5])
    }*/
    println()
    println("getOrNull(): ")
    println(strings.getOrNull(5))

    // Maximum value in a collection
    println()
    println("Max value in a collection: ")
    val ints = listOf(1, 2, 3)
    println(ints.max())

    // Join collections together.
    // The zip functions create pair elements. 'Pair' is a Kotlin class.
    // When the lists are not equals size the 'zip' function drops the access elements from the longer
    // It is useful when we have two list of related information and we want to bring them together
    // For instance, a list with names and another one with surnames
    println()
    println("Join collections together: ")
    println(colorList.zip(strings))

    // We can join the two lists together without creating pairs
    println()
    println("Merged lists: ")
    val mergedLists = listOf(colorList, strings)
    println(mergedLists)

    // Concatenating list together
    println()
    println("Combined lists: ")
    val combinedList = colorList + strings
    println(combinedList)

    // Combining two list without any duplicate item
    println()
    println("Combined lists without duplicates: ")
    val noDupsList = colorList.union(strings)
    println(noDupsList)

    // Removing duplicates from a list. The 'distinct()' function return a new list
    println()
    println("Removing duplicates from a list: ")
    val noDupColors = colorList.distinct()
    println(noDupColors)


}