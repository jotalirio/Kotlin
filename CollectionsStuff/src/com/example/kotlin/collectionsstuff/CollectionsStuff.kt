package com.example.kotlin.collectionsstuff

fun main(args: Array<String>) {

    val setInts = setOf(10, 15, 19, 5, 3, -22)

    val immutableMap =  mapOf(1 to Car("green", "Toyota", 2015),
                              2 to Car("red", "Ford", 2016),
                              3 to Car("silver", "Honda", 2013),
                              17 to Car("red", "BMW", 2015),
                              8 to Car("green", "Ford", 2010))

    val mutableMap =  mutableMapOf(1 to Car("green", "Toyota", 2015),
                              2 to Car("red", "Ford", 2016),
                              3 to Car("silver", "Honda", 2013))

    // Function 'filter'. The filter function returns a new instance so it does not operates on the collection directly
    println()
    println("Function 'filter': ")
    println(setInts.filter { it % 2 != 0 })
    println()
    println("The filtered immutable map is")
    println(immutableMap.filter { it.value.year == 2016 })

    mutableMap.filter { it.value.color == "silver" }
    println("The filtered mutable map is: ")
    println(mutableMap)

    // Function 'map'. The 'map' function returns a collection
    println()
    println("Function 'map': ")
    val ints = arrayOf(1, 2, 3, 4, 5)
/*    val add10List: MutableList<Int> = mutableListOf() // we have to indicate the type because we are not providing any initial value
    for (i in ints) {
        add10List.add(i + 10)
    }
    println(add10List)*/
    val add10List = ints.map { it + 10 }
    println(add10List.javaClass)
    println(add10List)

    println()
    println(immutableMap.map { it.value.year })

    println()
    println(immutableMap.filter { it.value.model == "Ford" }
                        .map { it.value.color })

    // Considering 2015 cars like newest
    println("Considering 2015 cars like newest")
    // Function 'all'
    println()
    println("We want to check if all the cars in the collection match a condition")
    println("Function 'all': ")
    println(immutableMap.all { it.value.year > 2014 })

    // Function 'any'
    println()
    println("We want to check if any car in the collection match a condition")
    println("Function 'any': ")
    println(immutableMap.any { it.value.year > 2014 })

    // Function 'count'
    println()
    println("We want to check how many cars in the collection match a condition")
    println("Function 'count': ")
    println(immutableMap.count { it.value.year > 2014 })

    val cars = immutableMap.values
    println()
    println("Finding the first item in the list that satisfies the condition and then stops")
    println("Function 'find': ")
    println(cars.find { it.year > 2014 })

    println()
    println("Grouping items by criteria")
    println("Function 'groupBy': ")
    println(cars.groupBy { it.color })

    println()
    println("Sorting Map by key...")
    println(immutableMap.toSortedMap())

    println()
    println("Sorting array cars by year...")
    println(cars.sortedBy { it.year })

}

data class Car(val color: String, val model: String, val year: Int)