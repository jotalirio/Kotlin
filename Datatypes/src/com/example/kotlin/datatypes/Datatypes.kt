package com.example.kotlin.datatypes


fun main(args: Array<String>) {

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
}