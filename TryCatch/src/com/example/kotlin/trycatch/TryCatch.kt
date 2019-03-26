package com.example.kotlin.trycatch

fun main(args: Array<String>) {


    // The 'try-catch' in Kotlin is similar to Java but in Kotlin we can use try catch as an expression
    // just like we can use the 'if' statement as an expression

    // In Kotlin we do not have to declare the exceptions that a function throws because Kotlin does not distinguish
    // between 'checked' and 'unchecked' exceptions


    // 'try-catch' as an expression
//    println(getNumber("22"))
//    println(getNumber("22.5"))


    // Using ELVIS operator to throw an Exception or return another value when there is a null value
//    println(getNumber("22.5") ?: throw IllegalArgumentException("Number is not an Int"))

    // This is an elegant way of handling return codes from functions that indicate that something went wrong, so instead of
    // throwing exceptions we could just do this and then we know we can keep on executing and everything is fine
    println(getNumber("22.5") ?: "I cannot print the result")

    // Type 'Nothing'
//    notImplementedYet("string")

}


//fun getNumber(str: String): Int {
//    return try {
//        Integer.parseInt(str)
//    }
//    catch (e: NumberFormatException) {
//        0
//    }
//    finally { // The 'finally' block is not involved in the evaluation of the value of a try-catch expression
//              // we can execute code in the finally block but no value will ever be returned from the finally block
//              // so if we want to return a value from the 'try-catch' we can only specify a value to return in the 'try' block
//              // or 'catch' block. Everything we specified to be returned in the finally block is going to be ignored
//        // Reminder: println() returns Unit (void)
//        println("I am in the finally block")
//        1
//    }
//}

//fun getNumber(str: String): Int {
//    return try {
//        Integer.parseInt(str)
//    }
//    catch (e: NumberFormatException) {
//        0
//    }
//    finally { // The 'finally' block is not involved in the evaluation of the value of a try-catch expression
//        // we can execute code in the finally block but no value will ever be returned from the finally block
//        // so if we want to return a value from the 'try-catch' we can only specify a value to return in the 'try' block
//        // or 'catch' block. Everything we specified to be returned in the finally block is going to be ignored
//        // Reminder: println() returns Unit (void)
//        println("I am in the finally block")
//        1
//    }
//}


/*

fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
//    catch (e: NumberFormatException) {
//        0
//    }
    finally { // The 'finally' block is not involved in the evaluation of the value of a try-catch expression
        // we can execute code in the finally block but no value will ever be returned from the finally block
        // so if we want to return a value from the 'try-catch' we can only specify a value to return in the 'try' block
        // or 'catch' block. Everything we specified to be returned in the finally block is going to be ignored
        // Reminder: println() returns Unit (void)
        println("I am in the finally block")
        1
    }

}

*/


fun getNumber(str: String): Int? {
    return try {
        Integer.parseInt(str)
    }
    catch (e: NumberFormatException) {
        null
    }
    finally {
        println("I am in the finally block")
    }
}


fun notImplementedYet(something: String): Nothing {
    throw IllegalArgumentException("Implement me!")
}

