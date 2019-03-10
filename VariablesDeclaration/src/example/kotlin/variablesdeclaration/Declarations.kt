package example.kotlin.variablesdeclaration

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {

    val inmutable1: Int = 25
    val inmutable2 = 25

    var mutable1: Int = 30
    var mutable2 = 30
    mutable2 = 40
    mutable2 = 50

    val employee1 = Employee(1, "Jose Javier Lirio")
    employee1.name = "Jose Lirio"

    val employee2: Employee
    if(inmutable1 < mutable2) {
        employee2 = Employee(2, "Luis Garcia")
    }
    else {
        employee2 = Employee(2, "Sarah Lopez")
    }

    // mutable Set
    val employees: EmployeeSet
    employees = mutableSetOf()
    employees.add(employee1)
    employees.forEach { println("id: " + it.id + ", " + "name: " + it.name) }

    // immutable ArrayList
    val names = arrayListOf("Jose", "Luis", "Sarah")
    print(names[1]) // Indexing the ArrayList without using .get() just like we usually do with Arrays in Java

}

class Employee(val id: Int, var name: String) {

}