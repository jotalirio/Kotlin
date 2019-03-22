package com.example.kotlin.inheritance

import java.time.Year


fun main(args: Array<String>) {

    // When we want to use an object declaration, we use it the same way that you use an instance of a class but using the class name
    // There is only one instance of the object and it is created the first time the class is used
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())
}


// We have a Singleton object called CompanyCommunications and this is how we do singletons in Kotlin. Nobody from the outside
// can create an instance of this class, the one single instance is created at the time we use the class, in this case at Line 10

// object declarations can extend classes and implement interfaces

// We can add properties and functions but we cannot have any constructors because an object declaration declares
// and creates an instance at the same time so having constructors would not make sense
object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}