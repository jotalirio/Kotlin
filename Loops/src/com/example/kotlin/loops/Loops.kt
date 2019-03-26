package com.example.kotlin.loops


fun main(args: Array<String>) {

    // The 'while' and 'do-while' loops have the same syntax and behave the same way as they do in Java
    // However, the 'for' loop has changed in Kotlin:

    // In Kotlin, 'for' loops use what is called 'ranges'. We can use 'ranges' in 'for' loops and assign them to variables
    // We can creates ranges outside loops and assign it to variables and we can also create them in the 'for' loop

    // The start and ends values are inclusive. All the values included in a range are greater than or equal in the start value
    // and less than or equal than the end value. We can also have ranges of chars and strings because both of them are comparable
    // so any type that is comparable can be used in a range. The types used in the have to be comparable because the 'in' operator
    // test whether a value is in a range

    val range = 1..5
    val charRange = 'a'..'z'
    val stringRange = "ABD".."XYZ"

    println(3 in range)
    println('q' in charRange)
    println("CCC" in stringRange)
    println("CCCCCC" in stringRange) // This sentence returns 'true' because this string even though it is longer, is less than XYZ and so it belongs to the string range
    println("ZZZZZZ" in stringRange) // This sentence returns 'false' because this string is grater than X and so it does not belong to the string range

    val b = 5..1
    // This sentence returns 'false' because 5 is greater than or equal to the start value but is not less or equal to the end value and so it does not belong to the range
    println(5 in b)

    // Down to: Allowed with numeric and char ranges
    val backwardRange = 5.downTo(1)
    // This sentence returns 'true' because we are using  the .downTo() function. So if we want to create a range that is in reverse order we have to use .downTo()
    println(5 in backwardRange)
    println('e' in 'z'.downTo('b'))
    println('a' in 'z'.downTo('b'))

    // Step range: Allowed with numeric and char ranges
    val stepRange = 3..15
    val stepThree = stepRange.step(3)

    // We can also reverse an existing range meaning that we can switch the start and end values, but we can only do this with numeric and char ranges
    val reversedRange = range.reversed()

    // Looping
    println()
    println("Printing the 'range'...")
    for (i in range) {
        println(i)
    }
    println()
    println("Printing 1..5 numbers")
    for (i in 1..5) {
        println(i)
    }
    println()
    println("Printing the 'stepRange'...")
    for (n in stepRange) {
        println(n)
    }
    println()
    println("Printing the 'stepThree'...")
    for (n in stepThree) {
        println(n)
    }
    println()
    println("Printing the 'reversedRange'...")
    for (i in reversedRange) {
        println(i)
    }
//    println()
//    println("Printing the 'stringRange'...")
      // Not allowed because stringRange does not have an iterator method so there is not a iterator method defined to the string range so we cannot loop it
//    for (s in stringRange) {
//        println(s)
//    }
    // The string Hello has an iterator method so we can iterate it
    val str = "Hello"
    println()
    println("Printing the 'Hello' string")
    for (c in str) {
        println(c)
    }
    println()
    println("Printing 1..20 numbers with step = 4")
    for (num in 1..20 step 4) {
        println(num)
    }
    println()
    println("Printing 20 downTo 15 numbers step = 5")
    for (i in 20 downTo 15 step 5) {
        println(i)
    }
    println()
    println("Printing 1 until 10")
    // Here the end value is excluded
    for (i in 1 until 10) {
        println(i)
    }

    // Looping over arrays
    println()
    println("Looping over arrays....")
    val seasons = arrayOf("spring", "summer", "winter", "fall")
    println()
    println("Printing for(season in seasons)")
    for (season in seasons) {
        println(season)
    }
    println()
    println("Printing for(index in seasons.indices)")
    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }
    println()
    println("Printing seasons.forEach { println(it) }")
    seasons.forEach { println(it) }
    println()
    println("Printing seasons.forEachIndexed { index, value -> println('value is season number index') }")
    seasons.forEachIndexed { index, value -> println("$value is season number $index") }

    val notAseason = "whatever" !in seasons
    println()
    println("Printing whatever !in seasons")
    println(notAseason)

    val notInRange = 32 !in 1..10
    println()
    println("Printing notInRange = 32 !in 1..10")
    println(notInRange)

    val anotherStr = "Hello"
    println("Printing 'e' in anotherStr")
    println('e' in anotherStr)
    println("Printing 'e' !in anotherStr")
    println('e' !in anotherStr)

    // Naming loops
    println("Naming loops....")
    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for (k in 5..10) {
                println("k = $k")
                if (k == 7) {
                    break@jloop;
                }
            }
        }
    }
}