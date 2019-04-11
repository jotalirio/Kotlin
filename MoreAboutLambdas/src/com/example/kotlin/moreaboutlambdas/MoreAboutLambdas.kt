package com.example.kotlin.moreaboutlambdas


fun main(args: Array<String>) {

    // Lambdas with receivers.
    // Function 'with'
    println()
    println(countTo100())

    // Function 'apply'. This function works in the same way that 'with' but it always returns the receiver object
    // So in our case instead of using 'with' and calling two string within the lambda we can use 'apply' function
    // and 'apply' will return the StringBuilder and then we will call toString() on the StringBuilder
    println()
    println(countTo100_Bis())

    val employees = listOf(Employee("John", "Smith", 2012),
        Employee("Jane", "Wilson", 2015),
        Employee("Mary", "Johnson", 2010),
        Employee("Mike", "Jones", 2002)
    )

    // Customized .find() function. Using labels for lambdas expression
    println()
    findByLastName(employees, "Wilson")
    findByLastName(employees, "Smithson")

    // More labels use cases
    println()
    "Some String".apply somestring@ {
        "Another String".apply {
            println(toLowerCase())
            println(this@somestring.toUpperCase())
        }
    }

}

/*fun countTo100(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}*/

// Function 'with'. The 'with' operator is receiving an instance and a lambda. In this case the lambda is the last parameter
// so with cat put it outside the parentheses. Now we are using the 'with' function, we don't have to refer to the instance
// when we want to call one of this member so we can remove 'numbers' from inside the 'for' loop

/*fun countTo100(): String {
    val numbers = StringBuilder()
    return with(numbers) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
}*/
// Function 'with' converts the instance that you pass to it into a receiver and inside the lambda we don't have to refer to the
// receiver object but we can if we want to. So 'with' function is converting the 'numbers' instance into the receiver object
// for the lambda expression
/*fun countTo100(): String {
    val numbers = StringBuilder()
    return with(numbers) {
        for (i in 1..99) {
            this.append(i)
            this.append(", ")
        }
        this.append(100)
        this.toString()
    }
}*/

// Using directly StringBuilder
/*fun countTo100(): String {
    return with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
}*/


// When all the function does is return a value and it does not do anything else then we can use an 'expression body',
// we don't have to use a 'block' body. This way is more concise, is more Kotlin way
fun countTo100() =
    with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }


// Function 'apply'
fun countTo100_Bis() =
    StringBuilder().apply {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
    }.toString()


// Customized .find() function
/*fun findByLastName(employees: List<Employee>, lastName: String) {
    for (employee in employees) {
        if (employee.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return
        }
    }
    println("Nope, there's no employee with the last name $lastName")
}*/


// Using a lambda without 'label'. In this case the 'return' statement is making a return for the lambda and the function
// so the last println("Nope...") is never executed. We have to make this return as a local return to the lambda expression
// using a label
//fun findByLastName(employees: List<Employee>, lastName: String) {
//    employees.forEach {
//        if (it.lastName == lastName) {
//            println("Yes, there's an employee with the last name $lastName")
//            return
//        }
//    }
//    println("Nope, there's no employee with the last name $lastName")
//}


// Using a lambda using 'label'. Now when an employee math with the lastName passed by parameter the local return is executed
// and the last println("Nope...") is executed
fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@ {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return@returnBlock
        }
    }
    println("Nope, there's no employee with the last name $lastName")
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int)