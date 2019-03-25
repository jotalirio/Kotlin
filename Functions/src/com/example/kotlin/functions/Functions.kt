package com.example.kotlin.functions



// The main function is returning Unit (void). When a function is not returning nothing we do not need to write ": Unit"
fun main(args: Array<String>) {

    // 1. Function with block body
    // 2. Function with expression body
    println(labelMultiply(3, 4, "The result is:"))

    // 4. Calling a function
    val emp = Employee("James")
    println(emp.upperCaseFirstName())

    // 5. Default values in function parameters
    println(labelMultiply(3, 4))

    // 6. Associating parameters values with names. When we are calling the function, the parameters order does not care
    println(labelMultiply(label = "Here is the result:", operand2 = 3, operand1 = 4))

    // 7. Vararg. We can only have one vararg argument in a function signature
    val numbers = arrayOf(1, 2, 3) // arrayOf(vararg)

    val car1 = Car("blue", "Toyota", 2015)
    val car2 = Car("red", "ford", 2016)
    val car3 = Car("yellow", "Renault", 2017)
//    printColor(car1, car2, car3)

    // 8. If the vararg argument is not the last argument in the function signature, then we have to use named parameters
//    printColor(car1, car2, car3, str = "Color: ")
//    printColor("Color: ", car1, car2, car3) // In this way, we do not need named parameters

    // 9. Spread operator. Unpack the elements of an array
    val manyCars = arrayOf(car1, car2, car3)
    printColor(*manyCars)
    val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()
    val lotsOfCars = arrayOf(*manyCars, *moreCars, car4)
    for (c  in lotsOfCars) {
        println(c)
    }

    // 10. Extension functions. A good use case is when we have a lot of auxiliary functions to manipulate Strings
    println(Utils().upperFirstAndLast("this is all in lowercase"))
    val str = "this is all in lowercase"
    println(str.upperFirstAndLast())

}

// 1. Function with block body
//fun labelMultiply(operand1: Int, operand2: Int, label: String): String {
//    return ("$label ${operand1 * operand2}")
//}


// 2. Function with expression body. We do not need to indicate the returned type. The compile knows that the returned value is String because the ""
// fun labelMultiply(operand1: Int, operand2: Int, label: String) = "$label ${operand1 * operand2}"


// 3. Main with expression body
//fun main(args: Array<String>) = println(labelMultiply(3, 4, "The result is:"))


// 4. Calling a function
// Classes are public and final by default
class Employee(val firstName: String) {

    // Functions are public and final by default
    fun upperCaseFirstName() = firstName.toUpperCase()
}


// 5. Default values in function parameters
//fun labelMultiply(operand1: Int, operand2: Int, label: String = "The answer is:") = "$label ${operand1 * operand2}"


// 6. Associating parameters values with names (named arguments). When we are calling the function, the parameters order does not care
fun labelMultiply(operand1: Int, operand2: Int, label: String = "The answer is:") = "$label ${operand1 * operand2}"


// 7. Vararg. We can only have one vararg argument in a function signature
data class Car(val color: String, val model: String, val year: Int) {

}

//fun printColor(vararg  cars: Car) {
//    for (car in cars) {
//        println(car.color)
//    }
//}


// 8. If the vararg argument is not the last argument in the function signature, then we have to use named parameters
//fun printColor(vararg  cars: Car, str: String) {
//    for (car in cars) {
//        println(car.color)
//    }
//}

//fun printColor(str: String, vararg  cars: Car) {
//    for (car in cars) {
//        println(car.color)
//    }
//}


// 9. Spread operator. Unpack the elements of an array
fun printColor(vararg  cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}


// 10. Extension functions. A good use case is when we have a lot of auxiliary functions to manipulate Strings
//fun String.upperFirstAndLast(): String {
//    val upperFirst = this.substring(0, 1).toUpperCase() + this.substring(1)
//    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(upperFirst.length - 1).toUpperCase()
//}


// We can remove this.
fun String.upperFirstAndLast(): String {
    val upperFirst = substring(0, 1).toUpperCase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(upperFirst.length - 1).toUpperCase()
}