package com.example.kotlin.ifexpression

fun main(args: Array<String>) {


    // The 'ternary operator' does not exists in Kotlin because the 'if' statement can return a value in which case it would be an
    // an expression so we do not need the ternary operator because the 'if' can act as a 'ternary operator', it can do the same thing

//    var num: Int
//
//    if (someCondition) {
//        num = 50
//    }
//    else {
//        num = 592
//    }
//
//    num = someCondition ? 50 : 592

    val someCondition = 69 < 22
    // Because the 'if' statement can evaluate a value, we can just write this and we do not need the 'ternary operator'
    // Here we are putting the return value as the last statement in each block or we can do something as we did up above
    val num = if (someCondition) 50 else 592

    // Equivalent but using blocks
    val num2 = if (someCondition) {
        println("something")
        50
    }
    else {
        println("something else")
        592
    }

    // Printing the expression
    println(num2)

    // Equivalent but using blocks
    println(if (someCondition) {
        println("something")
        50
    }
    else {
        println("something else")
        592
    })

    // Equivalent but using blocks and string templates
    println("The result of the if expression is ${if (someCondition) {
        println("something")
        50
    }
    else {
        println("something else")
        592
    }
    }")

    // Equivalent but using blocks
    val x = if (someCondition) {
        println("something")
    }
    else {
        println("something else")
    }
    // This sentence is returning the class kotlin.Unit
    println(x.javaClass)


}