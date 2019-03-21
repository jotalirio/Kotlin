package com.example.kotlin.accessmodifiers



val MY_CONSTANT = 100

fun main(args: Array<String>) {

    // 1. Long way
    // 2. First simplification
    // 3. Second simplification
    // 4. Third simplification
    // val emp = Employee("John")
    // println(emp.firstName)


    // 6. Adding a secondary constructor
    // 7. Assigning default value in constructor parameters
    // val emp2 = Employee("Joe")
    // println(emp2.firstName)
    // println(emp2.fullTime)

    // val emp3 = Employee("Jane", false)
    // println(emp3.firstName)
    // println(emp3.fullTime)
    // println("Changing the fullTime for Jane from false to true....")
    // emp3.fullTime = true
    // println(emp3.firstName)
    // println(emp3.fullTime)

    // 8. We do not have a primary constructor but we have a secondary one
    println(Demo().dummy)

    // 9. Making the fullTime property private
    // val emp4 = Employee("James")
    // println(emp4.firstName) // Doing that we are using the default getter provided by Kotlin
    // println(emp4.fullTime)  // The getter is now private and we cannot access to it

    // 10. Backing fields.  Declaring custom getters and setters. In this case the property cannot be part of the primary constructor
    val emp5 = Employee("James")
    println(emp5.firstName)
    println(emp5.fullTime)  // We are calling the custom get() getter
    println("Changing the fullTime for James from true to false....")
    emp5.fullTime = false   // We are calling the custom set() setter
    println(emp5.fullTime)

    // 11. Backing fields. Not allowing to change the value for the fullTime property
    // val emp6 = Employee("Patric")
    // println(emp6.firstName)
    // println(emp6.fullTime)  // We are calling the custom get() getter
    // println("Changing the firstName for Patric from Patric to Thomas....")
    // emp6.firstName = "Thomas"
    // println("Changing the fullTime for Thomas from true to false....")
    // emp6.fullTime = false   // We are calling the custom set() setter
    // println(emp6.fullTime)

    // 12. Constants
    println("MY_CONSTANT: $MY_CONSTANT")

    // 13. Data classes
    val car = Car("blue", "Toyota", 2015)
    println(car) // Default toString() function provided by Data classes
    println(emp5)
    val emp7 = Employee("Jonas")
    val emp7Bis = Employee("Jonas")
    println(emp7 == emp7Bis) // False: Is comparing references because the equals() method is not implemented in order to do an structural equality
    val carBis = Car("blue", "Toyota", 2015)
    println(car == carBis) // True: is making a structural equality because Data classes provide us a default equals() function
    val car2 = car.copy()
    println(car2)
    val car3 = car.copy(color = "yellow")
    println(car3)
    val car4 = car.copy(year = 2014, color = "green") // We are indicating the arguments name so the order does not care
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
//class Employee(val firstName: String, var fullTime: Boolean = true) {
//
//}


// 8. We do not have a primary constructor but we have a secondary one. We can use default values in secondary constructor as well
class Demo {

    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}


// 9. Making the fullTime property private. Kotlin by default provide getters and setters for each property with the same visibility
//    so if we make a property private then its getters and setters will be private as well and we would not be able to access to them
//class Employee(val firstName: String, private var fullTime: Boolean = true) {
//
//}


// 10. Backing fields.  Declaring custom getters and setters. In this case the property cannot be part of the primary constructor
class Employee(val firstName: String, fullTime: Boolean = true) {

    // At this point, Kotlin would provide the default getter and setter as well
    // Declaring a backing fields
    var fullTime = fullTime
    get() {
        println("Running the custom get...")
        return field
    }
    set(value) {
        println("Running the custom set...")
        field = value
    }
}


// 11. Backing fields. Not allowing to change the value for the fullTime property
//class Employee(var firstName: String, fullTime: Boolean = true) {
//
//    // At this point, Kotlin would provide the default getter and setter as well
//    // Declaring a backing fields
//    var fullTime = fullTime
//    get() {
//        println("Running the custom get...")
//        return field
//    }
//    private set(value) {
//        println("Running the custom set...")
//        field = value
//    }
//}


// 13. Data class provide us getters() and setters(), copy(), a custom implementation of equals() and hashcode() and toString() functions by default.
// We can override them and then our versions of these functions will be used
// The primary constructor has to have at least one parameter and all parameters have to be val or var. We cannot have regular parameters (parameters without val or var)
// Data classes cannot be abstract, sealed or inner classes
// We can have properties not included in the primary constructor but Kotlin is not going to include them into the default functions: copy(), equals() and hashcode()
// Kotlin is not going to take these properties into account so it is better to have them into the primary constructor signature
data class Car(val color: String, val model: String, val year: Int) {

}