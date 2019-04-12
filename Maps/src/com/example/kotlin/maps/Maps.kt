package com.example.kotlin.maps


fun main(args: Array<String>) {

    // The compiler can infer the Map type parameters
    val immutableMap = mapOf(1 to Car("green", "Toyota", 2015),
                             2 to Car("red", "Ford", 2016),
                             3 to Car("silver", "Honda", 2013))

    println()
    println("Immutable Map: ")
    println(immutableMap.javaClass) // Kotlin used a LinkedHashMap
    println(immutableMap)

    val mutableMap = mutableMapOf<String, Car>("John's car" to Car("red", "Range Rover",2010),
                                               "Jane's car" to Car("blue", "Hyundai", 2012))
    println()
    println("Mutable Map: ")
    println(mutableMap.javaClass)
    println(mutableMap)

    // In this way, the Map is always mutable
    val mutableHashMap = hashMapOf<String, Car>("John's car" to Car("red", "Range Rover",2010),
                                                "Jane's car" to Car("blue", "Hyundai", 2012))

    println()
    println("Mutable HashMap: ")
    println(mutableHashMap.javaClass)
    println(mutableHashMap)
    mutableHashMap.put("Mary's car", Car("red", "Corvette", 1965))

    // Destructuring declarations. // We have taken an instance and destructuring it
    println()
    println("Destructuring declarations: ")
    val pair = Pair(10, "ten")
//    val firstValue = pair.first
//    val secondValue = pair.second
    val (firstValue, secondValue) = pair
    println("First value: $firstValue")
    println("Second value: $secondValue")

    // Iterating mutable Map
    println()
    println("Iterating mutable Map:")
    println("Using 'entry':")
    for (entry in mutableMap) {
        println("entry: ${entry.key}")
        println("entry: ${entry.value}")
    }

    println()
    println("Using (key, value) pair:")
    // We are destructuring the entry into a pair (k, v)
    for ((k, v) in mutableMap) {
        println("entry: $k")
        println("entry: $v")
    }

    // Components functions
    println()
    println("Component functions:")
    val car = Car("blue", "Corvette", 1959)
    val (color, model, year) = car
    println("Car color: $color")
    println("Car model: $model")
    println("Car year: $year")

}


/*
class Car(val color: String, val model: String, val year: Int) {

    // Components functions. The attributes have to be 'public' in the destructuring
    // If the attributes are 'private' they can participate in the destructuring
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}*/

// For 'data Classes' this functions are already included for destructuring declaration so we don't have to explicitly
// write the component functions for data classes
data class Car(val color: String, val model: String, val year: Int) {

}

