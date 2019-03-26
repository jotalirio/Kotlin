package com.example.kotlin.whenpkg

import java.math.BigDecimal


enum class Season {
    SPRING, SUMMER, FALL, WINTER
}

fun main(args: Array<String>) {


    // 'switch' statement does not exists in Kotlin instead we use the 'when' statement

    val num = 200

    // When statement does not use 'break' like Java. In Kotlin we can only execute one branch
    when(num) {
        100 -> println("100")
        200 -> println("200")
        300 -> println("300")
        else -> println("Does not match anything")
    }

    // Or
    val num2 = 100

    when (num2) {
        100, 600 -> println("600")
        200 -> println("200")
        300 -> println("300")
        else -> println("Does not match anything")
    }

    // We also can use 'ranges'
    val num3 = 150

    when (num3) {
        in 100..199 -> println("in range 100.199")
        200 -> println("200")
        300 -> println("300")
        else -> println("Does not match anything")
    }

    // We can also use expressions for the values as follow
    val y = 10

    when (y) {
        y + 80 -> println("90")
        y + 90 -> println("100")
        300 -> println("300")
        else -> println("Does not match anything")
    }

    // Using smart casting we can check what the type of an object is and then do something with it depending on the type
    val obj1: Any = "I am a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45
    val something: Any = obj2
//    if (something is String) { // Here we are using smart casting and it is not necessary to check another time inside the condition if te variable is String
//        println(something.toUpperCase())
//    }
//    else if (something is BigDecimal) {
//        println(something.remainder(BigDecimal(10.5)))
//    }
//    else if (something is Int) {
//        println("${something - 22}")
//    }

    when (something) {
        is String -> println(something.toUpperCase()) // Here we are using smart casting and it is not necessary to check another time inside the condition if te variable is String
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
        is Int -> println("${something - 22}")
    }

    // Assigning the 'when' result to a variable. To do that is mandatory to have the 'else' statement
    val z = when (something) {
        is String -> println(something.toUpperCase()) // Here we are using smart casting and it is not necessary to check another time inside the condition if te variable is String
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
        is Int -> println("${something - 22}")
        else -> println("I have no idea what type this is")
    }
    // The println() is returning the Unit type (void)
    println(z)


    val w = when (something) {
        is String -> { // Here we are using smart casting and it is not necessary to check another time inside the condition if te variable is String
            println(something.toUpperCase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            2
        }
        is Int -> {
            println("${something - 22}")
            3
        }
        else -> {
            println("I have no idea what type this is")
            -1
        }
    }
    println(w)


    // enum class
    val timeOfYear = Season.WINTER
    // In this case we do not need the 'else' statement, that is because the branches in this case are exhaustive because
    // we are using an enum and the compiler knows that because 'timeOfYear' is of type 'Season' it knows that there are 4 possible values
    // and we have listed all those values so the 'else' statement never will be executed. In this case the compiler can guarantee that
    // a value will be returned
    val str = when(timeOfYear) {
        Season.SPRING -> "Flowers are blooming!"
        Season.SUMMER -> "It is hot!"
        Season.FALL -> "It is getting cooler"
        Season.WINTER -> "I need a coat"
    }
    println(str)

    // If we remove one of the 4 possible values then the compiler is reporting an error
    // saying that the 'else' statement is missed
    /*
    val str = when(timeOfYear) {
        Season.SPRING -> "Flowers are blooming!"
        Season.SUMMER -> "It is hot!"
        Season.FALL -> "It is getting cooler"
//        Season.WINTER -> "I need a coat"
    }
    */

    var num4 = 100
    val r = when(timeOfYear) {
        Season.SPRING -> {
            "Flowers are blooming!"
            num4 += 5 // This will show in the console the following output: kotlin.Unit because this expression is not returning nothing
        }
        Season.SUMMER -> "It is hot!"
        Season.FALL -> "It is getting cooler"
        Season.WINTER -> "I need a coat"
    }
    println(r)

    var num5 = 100
    val u = when(timeOfYear) {
        Season.SPRING -> {
            num5 += 5
            "Flowers are blooming!"
        }
        Season.SUMMER -> "It is hot!"
        Season.FALL -> "It is getting cooler"
        Season.WINTER -> {
            num5 = 22 - 55
            "I need a coat"
        }
    }
    println(u)

    // Here we are not really testing a value, we are testing 2 different conditions and if both of those conditions fail
    // we want to execute a third block of code
    val num6 = -50
    if (num5 < num6) {
        println("num5 is less than num6")
    }
    else if (num5 > num6) {
        println("num5 is greater than num6")
    }
    else  {
        println("num5 = num6")
    }

    // Converting the previous code using 'when' we do not need the brackets ()
    when {
        num5 < num6 -> println("num5 is less than num6")
        num5 > num6 -> println("num5 is greater than num6")
        else -> println("num5 = num6")
    }
}