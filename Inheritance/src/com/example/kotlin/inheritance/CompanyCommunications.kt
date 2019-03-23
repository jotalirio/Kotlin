package com.example.kotlin.inheritance

import java.time.Year


fun main(args: Array<String>) {

    // 13. Singletons in Kotlin.
    // When we want to use an object declaration, we use it the same way that you use an instance of a class but using the class name
    // There is only one instance of the object and it is created the first time the class is used
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())


    // 14. Companion objects
    // We are able to access the function without needing an instance of the class
    // println(Someclass.Companion.accessPrivateVar())
    println(Someclass.accessPrivateVar())


    // 14.1 Companion object name
    // println(Someclass.SomeCompanion.accessPrivateVar())


    // 14.2 We can use companion objects to call private constructors. In fact you can use it to implement the Factory pattern.
    val anyClass1 = AnyClass.justAssign("this is the string as is")
    val anyClass2 = AnyClass.upperOrLowerCase("this is not the string as is", false)
    println(anyClass1.someString)
    println(anyClass2.someString)
    // As the primary constructor is private we cannot access to this constructor directly. To declare instances of the class
    // we have to use the Factory methods
    // val anyClass3 = AnyClass()


}


// 13. Singletons in Kotlin.

// In Kotlin the 'static' keyword does not exist. We cannot declare anything static, instead we can use top-level functions and properties
// or use 'object' declarations when it makes sense

// We have a Singleton object called CompanyCommunications and this is how we do singletons in Kotlin. Nobody from the outside
// can create an instance of this class, the one single instance is created at the time we use the class, in this case at Line 10

// 'object' declarations can extend classes and implement interfaces

// We can add properties and functions but we cannot have any constructors because an object declaration declares
// and creates an instance at the same time so having constructors would not make sense
object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}


// 14. Companion objects

// In Kotlin the 'static' keyword does not exist. We cannot declare anything static, instead we can use top-level functions and properties
// or use 'object' declarations when it makes sense

// We cannot call the 'accessPrivate()' function without make an instance of the class. Because the 'static' keyword does not exist in Kotlin
// because we cannot declare anything as static, it is not possible to access functions and public static members, within classes
// without having an instance of the class. We always need an instance of the class to access anything that is inside a class
//class Someclass {
//
//    private val privateVar = 6
//
//    fun accessPrivate() {
//        println("I am accessing privateVar: $privateVar")
//    }
//}


// So how can we have something inside a class, but not need an instance to access it? --> Using 'companion' objects
// We can create companion objects inside classes and we can access to these 'companion' objects without need an instance of the class

// In this way, we can call the access accessPrivateVar() without needing an instance of some class.
class Someclass {

    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I am accessing privateVar: $privateVar"
    }
}


// 14.1 Companion object name
//class Someclass {
//
//    companion object SomeCompanion {
//        private var privateVar = 6
//
//        fun accessPrivateVar() = "I am accessing privateVar: $privateVar"
//    }
//}


// 14.2 We can use companion objects to call private constructors. In fact you can use it to implement the Factory pattern.
// We can add functions to our companion object that return instances of some class, in other words the companion object can
// act as a factory

// Making the primary constructor private if we want an instance of the class we have to use the 'justAssign()' or 'upperOrLowerCase()' function
class AnyClass private constructor(val someString: String) {

    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I am accessing privateVar: $privateVar"

        fun justAssign(str: String) = AnyClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): AnyClass {
            if (lowerCase) {
                return AnyClass(str.toLowerCase())
            }
            else {
                return AnyClass(str.toUpperCase())
            }
        }
    }
}