package com.example.kotlin.lambdas


fun main(args: Array<String>) {

    // Lambdas in Kotlin have to be within curly braces and we can store them in variables and we can also call them
    // directly using the 'run' function. 'Run' is a library function that runs lambdas us
    run { println("I am in a lambda!") }

    // Lambdas over Collections
    val employees = listOf(Employee("John", "Smith", 2012),
                           Employee("Jane", "Wilson", 2015),
                           Employee("Mary", "Johnson", 2010),
                           Employee("Mike", "Jones", 2002)
    )


    // When the lambda expression has to be moved outside parentheses: The rule is we can move a lambda outside the parentheses
    // when it is the last parameter in the function call and in this case it is the last parameter because it is the only parameter
    // If we have 2 parameters and the lambda is still the last, we could still move the lambda outside the parentheses but if
    // the is not the last argument, for instance the lambda is in the first position, then we would not be able to move it outside
    // So this is something to keep in mind when we write functions that take lambdas and we want to be able to move the lambdas
    // outside parentheses. The lambda has to be the last parameter, not the first one or another position that is not the last one

    // Printing an Employee with the minimum 'startYear'
    println()
    println(employees.minBy ({ e -> e.startYear }))

    // Specifying the type of the lambda item
    println()
    println(employees.minBy { e: Employee -> e.startYear })

    // The type of 'e' is inferred by the compiler
    println()
    println(employees.minBy { e -> e.startYear })

    // We have the special 'it' parameter that we can use it when there is only one parameter and the compiler can infer the type
    // we do not need to declare the parameter 'e' like we are doing up above because the compiler understand that it is the parameter
    // to the lambda so we can do this more concise using the 'it' parameter
    println()
    println(employees.minBy { it.startYear })

    // Member references: we can use a member reference in place of a lambda expression when all that lambda does is access a property
    // or when it calls a top-level function that does not take any parameters
    println()
    println(employees.minBy(Employee::startYear))

    // Scope: Lambdas can access local variables as long as they are declare before the lambda when we use a lambda within a function
    // they can also access the function parameters
    println()
    var num = 10
    run {
        num += 15
        println(num)
    }

    // Using top-level functions in lambdas. There are no parentheses after function name because when we do this with the top-level function
    // it can't accept arguments. The function can have a return value but no parentheses
    println()
    run(::topLevel)

}

// Scope: Lambdas can access local variables as long as they are declare before the lambda when we use a lambda within a function
// they can also access the function parameters. We can't change 'num' because function parameters are 'val' and not 'var'
fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num)
    }
}

fun topLevel() = println("I am in a function!")


data class Employee(val firstName: String, val lastName: String, val startYear: Int)

