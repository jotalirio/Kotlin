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
    println()

    // immutable ArrayList
    val names = arrayListOf("Jose", "Luis", "Sarah")
    print(names[1]) // Indexing the ArrayList without using .get() just like we usually do with Arrays in Java
    println()

    val employeeOne = Employee(555, "Laura")
    val employeeTwo = Employee(666, "Manuel")
    val employeeThree = Employee(666, "Manuel")
    println()
    // == is using equals so is doing a structural equality
    println(employeeOne == employeeTwo)
    println(employeeTwo == employeeThree)
    println(employeeOne.equals(employeeTwo))
    println(employeeTwo.equals(employeeThree))
    // === is doing a referential equality
    println(employeeOne === employeeTwo)
    println(employeeTwo === employeeThree)
    val employeeFour = employeeTwo
    println(employeeFour != employeeTwo)
    println(employeeFour !== employeeTwo)
    println(employeeTwo === employeeThree)
    println(employeeTwo === employeeThree)
}

class Employee(val id: Int, var name: String) {

    override fun equals(obj: Any?): Boolean {
        if(obj is Employee) {
            return name == obj.name && id == obj.id
        }
        return false
    }
 }