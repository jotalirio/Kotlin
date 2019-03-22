package com.example.kotlin.inheritance


fun main(args: Array<String>) {

    // 5. Adding method printModel()
    // 6. Overriding the printModel() method in the subclass
    // 7. Adding an abstract method.
    // 8. Using explicitly the 'final' keyword.
//    val laserPrinter = LaserPrinter("Stylus Color 450")
//    laserPrinter.printModel()

    // 9. The primary constructor signatures for the parent and child classes don not have to match
//    val laserPrinter = LaserPrinter("Stylus Color 450", 15)
//    laserPrinter.printModel()

    // 10. Secondary constructors
    SomethingElse("whatever")
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
//abstract class Printer(val modelName: String) {
//
//    // Methods are by default public and static so we have to use the 'open' keyword to override methods
//    open fun printModel() = println("The model name of this printer is '$modelName'")
//    abstract fun bestSellingPrice(): Double
//}
//
//class LaserPrinter(modelName: String): Printer(modelName) {
//
//    override fun printModel() = println("The model name of this laser printer is '$modelName'")
//    override fun bestSellingPrice(): Double = 129.99
//
//}


// 8. Using explicitly the 'final' keyword. 'Override' keyword is saying that the method is still open so subclasses can continue override that method.
// So if we want to avoid that we have to use the 'final' keyword
//abstract class Printer(val modelName: String) {
//
//    // Methods are by default public and static so we have to use the 'open' keyword to override methods
//    open fun printModel() = println("The model name of this printer is '$modelName'")
//    abstract fun bestSellingPrice(): Double
//}
//
//// Now we want that all LaserPrinter subclass use the original printModel() method from the LaserPrint class
//open class LaserPrinter(modelName: String): Printer(modelName) {
//
//    // Adding the 'final' keyword to this method, subclasses cannot override it
//    final override fun printModel() = println("The model name of this laser printer is '$modelName'")
//    override fun bestSellingPrice(): Double = 129.99
//
//}
//
//class SpecialLaserPrinter(modelName: String): LaserPrinter(modelName) {
//
//    // uncomment the line to see the compiler error
//    // override fun printModel() = println("this is my way of doing it")
//}


// 9. The primary constructor signatures for the parent and child classes don not have to match
//abstract class Printer(val modelName: String) {
//
//    open fun printModel() = println("The model name of this printer is '$modelName'")
//    abstract fun bestSellingPrice(): Double
//}
//
//open class LaserPrinter(modelName: String, ppm: Int): Printer(modelName) {
//
//    // Adding the 'final' keyword to this method, subclasses cannot override it
//    final override fun printModel() = println("The model name of this laser printer is '$modelName'")
//    override fun bestSellingPrice(): Double = 129.99
//
//}
//
//class SpecialLaserPrinter(modelName: String, ppm: Int, year: Int): LaserPrinter(modelName, ppm) {
//
//}


// 10. We cannot call a super secondary constructor if you have a primary constructor because every constructor has to
// delegate to the primary constructor so calling a super secondary constructor only makes sense if you do not have a
// primary constructor and if you do not you would call one of the Super secondary constructors by adding : in super()
// after the Child's constructor. So we can only really call a Super class secondary constructor when no primary constructor
// are involved

//open class Something {
//
//    val someProperty: String
//
//    constructor(someParameter: String) {
//        someProperty = someParameter
//        println("I am in the Parent's constructor")
//    }
//}
//
//class SomethingElse: Something {
//
//    constructor(someOtherParameter: String): super(someOtherParameter) {
//        println("I am in the Child's constructor")
//    }
//}

// 10.1. We can see most of the time we only want a primary constructor and we really only want to start adding
// secondary constructors when it's absolutely necessary. We can see we can quickly get into trouble if we start tying
// to split the responsibility between the primary and secondary constructors
//open class Something(val x: Int) {
//
//    val someProperty: String = "lalalala"
//
//    constructor(someParameter: String, y: Int): this(y) {
//        someProperty = someParameter
//    }
//}
//
//class SomethingElse: Something {
//
//    constructor(someOtherParameter: String, z: Int): super(z)
//}


// 11. Data classes. We cannot extend data Classes because they are closed tight so they cannot be extended. In fact they
// can even be abstract or inner classes because that would not make sense. Right if a data class exists just to store state
// then it does not make sense to have it as an abstract or inner class.
//
// They can extend other classes but when it comes to inheritance the buck stops right with them
//open data class DataClass (val number: Int) {
//
//}


// 12. Interfaces.
// We do not need to use the 'open' keyword to extend an interface
interface MyInterface {

    // This property is abstract because we have not assigned it an initial value
    val number: Int

    // We can initialize properties within interfaces
    // val number2: Int = 50

    // We can solve the above situation using a get()
    val number3: Int
        get() = 45

    val number4: Int
        get() = number * 100

    // Backing fields are not allowed
//    val number5: Int
//        get() = field * 100


    fun myFunction(str: String): String
}

interface MySubInterface: MyInterface {

    fun mySubFunction(num: Int): String
}

open class Something: MySubInterface {

    val someProperty: String
    override val number: Int = 25

    constructor(someParameter: String) {
        someProperty = someParameter
        println("I am in the Parent's constructor")
    }

    override fun myFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mySubFunction(num: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class SomethingElse: Something {

    constructor(someOtherParameter: String): super(someOtherParameter) {
        println("I am in the Child's constructor")
    }
}

abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is '$modelName'")
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(modelName: String, ppm: Int): Printer(modelName), MyInterface {

    override val number: Int = 25
    override val number3: Int = 75
    override val number4: Int = 55

    // Adding the 'final' keyword to this method, subclasses cannot override it
    final override fun printModel() = println("The model name of this laser printer is '$modelName'")
    override fun bestSellingPrice(): Double = 129.99

    override fun myFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class SpecialLaserPrinter(modelName: String, ppm: Int, year: Int): LaserPrinter(modelName, ppm) {

}


// 13. Singletons in Kotlin.
// In Kotlin there is a way to declare a class and define an instance at the same time using the 'object' keyword
// Now, there are three typical uses for the 'object' keyword:

//      - Singletons
//      - Companion objects
//      - Objects expressions