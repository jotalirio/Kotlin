package com.example.kotlin.datatypes


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

}