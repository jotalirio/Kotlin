package com.example.kotlin.datatypes

import com.example.kotlin.javacode.DummyClass
import java.math.BigDecimal


fun main(args: Array<String>) {

    /*** Numeric data types ***/

    val myInt = 10
    print("default datatype is ${myInt is Int}")
    var myLong = 22L

    // int myInt = 10;
    // long myLong = myInt; //Java converts this to a long when it assigns of value, not a problem. Java automatically widens the integer

    // In Kotlin:
    myLong = myInt.toLong() // Kotlin does not wide automatically the integer

    // Another example
    // byte myByte = 111;
    // short myShort = myByte; //Java converts this to a short when it assigns of value, not a problem. Java automatically widens the short

    val myByte: Byte = 111
    var myShort: Short

    myShort = myByte.toShort() // Kotlin does not wide automatically the short


    // Double
    var myDouble = 65.984
    println()
    println(myDouble is Double)

    //Float
    val myFloat = 838.8492f
    println()
    println("This is a float: ${myFloat is Float}")

    // Reminder: There is no automatic widening. The values are not automatically widened when you are assigning them to a wider data type.
    // You have to explicitly do the widening by calling the appropriate two data type function
    myDouble = myFloat.toDouble()


    /*** Char data types ***/

    val char = 'b'

    //In Java is representing the UTF-8 and ASCII character A.
    // char c = 65;

    // In Kotlin
    val myCharInt = 65
    // If you have a character literal as a numeric and you want to actually get it into a char variable you have to explicitly do that
    // there is no automatic conversion done for us
    print(myCharInt.toChar())

    /*** Boolean data type ***/
    val myBoolean = true


    /*** Instantiating DummyClass java class ***/

    val vacationTime = false
    val onVacation = DummyClass().isVacationTime(vacationTime)
    println()
    println(onVacation)


    /*** Array class ***/

    val names = arrayOf("John", "Jane", "Jill", "Joe")

    val longs1 = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(1, 2, 3, 4)
    val longs3 = arrayOf(1, 2, 3, 4)
    println()
    println(longs1 is Array<Long>)
    println(longs2 is Array<Long>)
    // println(longs3 is Array<Long>) // The compiler tells us that not is an Array<Long>
    println(longs3 is Array<Int>)

    // Usually arrays indexing
    println(longs1[2])

    // Initializing an array using a lambda expression
    // This lambda expression is multiplying the index of 16 elements by 2
    val evenNumbers = Array(16){ i -> i * 2 }
    println("Printing evenNumbers array: ")
    for (number in evenNumbers) {
        println(number)
    }
    println(evenNumbers is Array<Int>)

    val lotsOfNumbers = Array(100000) { i -> i + 1 } // 1, 2, 3, ...100000
    // val allZeroes = Array(100) { i -> 0 } // 0, 0, 0, 0...
    val allZeroes = Array(100) { 0 } // 0, 0, 0, 0...

    var someArray: Array<Int>
    someArray = arrayOf(1, 2, 3, 4)
    println("Printing someArray array: ")
    for (number in someArray) {
        println(number)
    }

    someArray = Array(6) { i -> (i + 1) * 10 }
    println("Printing someArray array: ")
    for (number in someArray) {
        println(number)
    }


    // Mixing data types in an Array: array of Any
    val mixedArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
    println("Printing mixedArray array: ")
    for (elem in mixedArray) {
        println(elem)
    }
    println(mixedArray is Array<Any>)

    val myIntArray = intArrayOf(3, 9, 434, 2, 33) // array that map a primitive array: int[]
    DummyClass().printNumbers(myIntArray)

    var someOtherArray = IntArray(5) // [0, 0, 0, 0, 0]
    println("Printing someOtherArray array: ")
    for (number in someOtherArray) {
        println(number)
    }

    // We are converting an array of general Array class to an array that map a primitive array: int[]
    DummyClass().printNumbers(evenNumbers.toIntArray())

    val convertedIntArray: Array<Int> = myIntArray.toTypedArray()
}