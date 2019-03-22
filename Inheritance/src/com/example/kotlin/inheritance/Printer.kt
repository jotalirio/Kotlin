package com.example.kotlin.inheritance


fun main(args: Array<String>) {

    // 5. Adding method printModel()
    // 6. Overriding the printModel() method in the subclass
    // 7. Adding an abstract method.
    val laserPrinter = LaserPrinter("Stylus Color 450")
    laserPrinter.printModel()
}




// 1. Basic inheritance. Classes are by default public static so we need to use the 'open' keyword to extend classes
//open class Printer() {
//}
//
//class LaserPrinter(): Printer() {
//
//}


// 2. If we do not want a primary constructor we could also go like this. We add a secondary constructor and all it does
// basically is defer to super
//open class Printer {
//}
//
//class LaserPrinter: Printer {
//
//    constructor(): super()
//}


// 3. Adding the modelName: String property
//open class Printer(val modelName: String) {
//}
//
//// We will delegate the handling of that to the primary constructor
//class LaserPrinter(modelName: String): Printer(modelName) {
//
//}


// 4. The Printer class does not represent one specific model of a printer so we can make this class abstract
// Now we have an abstract class and we have on subclass

// Redundancy: We use the keyword open to be able to extend a class and an abstract class cannot be instantiated so
// it has to be extended otherwise they are going to be useless so when we have an abstract class we can omit the keyword 'open'
// We do not have to use the 'open' keyword with abstract classes
//abstract class Printer(val modelName: String) {
//}
//
//class LaserPrinter(modelName: String): Printer(modelName) {
//
//}


// 5. Adding method printModel()
//abstract class Printer(val modelName: String) {
//
//    fun printModel() = println("The model name of this printer is '$modelName'")
//}
//
//class LaserPrinter(modelName: String): Printer(modelName) {
//
//}


// 6. Overriding the printModel() method in the subclass
//abstract class Printer(val modelName: String) {
//
//    // Methods are by default public and static so we have to use the 'open' keyword to override methods
//    open fun printModel() = println("The model name of this printer is '$modelName'")
//}
//
//class LaserPrinter(modelName: String): Printer(modelName) {
//
//    override fun printModel() = println("The model name of this laser printer is '$modelName'")
//
//}


// 7. Adding an abstract method. Abstract method are 'open' by default. When a method is abstract we do not have to use
// the 'open' keyword but we still have to use the 'override' keyword
abstract class Printer(val modelName: String) {

    // Methods are by default public and static so we have to use the 'open' keyword to override methods
    open fun printModel() = println("The model name of this printer is '$modelName'")
    abstract fun bestSellingPrice(): Double
}

class LaserPrinter(modelName: String): Printer(modelName) {

    override fun printModel() = println("The model name of this laser printer is '$modelName'")

    override fun bestSellingPrice(): Double = 129.99

}