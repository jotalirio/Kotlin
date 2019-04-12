package com.example.kotlin.collections


fun main(args: Array<String>) {

    // Kotlin uses the Java Collections classes but we will see that there sometimes it uses its own. But even when
    // it is  using Java Collections classes we can do more with Collections in Kotlin

    // Kotlin has the notion of mutable and immutable Collections we can operate on. Working with immutable Collections
    // we can add and remove items but the result will be a brand new instance so the instance itself is never changed

    // All Collections take a generic type and all the read only interfaces are covariant. We can do something like
    // assign a list of big decimal to a list of any because when something is covariant you can treat a class
    // like one of its parent classes so because big decimal is a subclass of any you can assign a list of big decimal
    // to a list of any

    // The Collection interface is implemented by the List and Set collections

    // In Kotlin, ArrayList is immutable but it is not in Java so when we say that a collection is immutable we mean that
    // it is guaranteed to be immutable from Kotlin so if we pass an instance of an immutable collection to Java code,
    // the immutable characteristic is off
    println()
    val strings = listOf("winter", "spring", "summer", "fall")
    println(strings.javaClass)

    // Empty list
    println()
    val emptyList = emptyList<String>()
    println(emptyList.javaClass)
    if (!emptyList.isEmpty()) {
        println(emptyList[0])
    }

    // List that not contains nulls. The null value is never added to the list
    val notNullList = listOfNotNull("hello", null, "goodbye")
    println()
    println(notNullList)

    // ArrayList. Now we have a mutable ArrayList
    val arrayList = arrayListOf(1, 2, 3)
    println()
    println(arrayList.javaClass)

    // MutableList. Now we get a mutable ArrayList again. So when we ask for a immutable list we are going to get a Java
    // utility arrays ArrayList. We we ask for an ArrayList explicitly or we just ask for immutable list we are going to get
    // a java.util.ArrayList
    val mutableList = mutableListOf(1, 2, 3)
    println()
    println(mutableList.javaClass)

    // Using the square bracket notation
    println(mutableList[2])
    mutableList[1] = 20
    println(mutableList)

    // From array to list
    val colorArray = arrayOf("black", "white", "green")
    val colorList = listOf(colorArray)
    println()
    println(colorList) // this is printing the memory reference

    // Using the spread operator '*' we can unpack an array
    val colorArray2 = arrayOf("black", "white", "green")
    val colorList2 = listOf(*colorArray2)
    println()
    println(colorList2)

    // Or we can do this
    val colorArray3 = arrayOf("black", "white", "green")
    val colorList3 = colorArray3.toList()
    println()
    println(colorList3)

    // Int array to List
    val intArray = intArrayOf(1, 2, 3)
    println()
    println(intArray.toList())


}