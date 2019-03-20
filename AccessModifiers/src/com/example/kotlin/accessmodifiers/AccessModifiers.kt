package com.example.kotlin.accessmodifiers


fun main(args: Array<String>) {

    // 1. Long way
    // 2. First simplification
    // 3. Second simplification
    // 4. Third simplification
    // val emp = Employee("John")
    // println(emp.firstName)


    // 6. Adding a secondary constructor
    // 7. Assigning default value in constructor parameters
    val emp2 = Employee("Joe")
    println(emp2.firstName)
    println(emp2.fullTime)

    val emp3 = Employee("Jane", false)
    println(emp3.firstName)
    println(emp3.fullTime)


    // 8. We do not have a primary constructor but we have a secondary one
    println(Demo().dummy)
}

// 1. Long way
//class Employee constructor(firstName: String) {
//
//    val firstName: String
//
//    init {
//        this.firstName = firstName
//    }
//
//}


// 2. First simplification
//class Employee constructor(firstName: String) {
//
//    val firstName: String = firstName
//}


// 3. Second simplification. Creating the property at the same time adding 'val' to the constructor parameter
//class Employee(val firstName: String) {
//
//}


// 4. Third simplification. If we have annotations or access modifiers we cannot remove the constructor keyword
//class Employee(val firstName: String) {
//
//}


// 5. Changing the primary constructor visibility. By default is public
//class Employee protected constructor(val firstName: String) {
//
//}


// 6. Adding a secondary constructor
//class Employee(val firstName: String) {
//
//    var fullTime: Boolean = true
//
//    constructor(firstName: String, fullTime: Boolean): this(firstName) {
//        this.fullTime = fullTime
//    }
//}


// 7. Assigning default value in constructor parameters
class Employee(val firstName: String, var fullTime: Boolean = true) {

}


// 8. We do not have a primary constructor but we have a secondary one. We can use default values in secondary constructor as well
class Demo {

    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}