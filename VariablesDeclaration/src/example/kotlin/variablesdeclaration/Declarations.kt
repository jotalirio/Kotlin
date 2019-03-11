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

    // instanceOf and Smart casting
    var something: Any = employeeFour
    if(something is Employee) {
        // val newEmployee = something as Employee
        something = employeeOne
        // something = "hello"
        println(something.name)
    }

    // String templates
    val employeeFive = Employee(27, "Paula")
    println(employeeFive)

    val change = 4.22
    println("To show the value change, we use \$change")
    println("To show the value change, we use $change")
    println("To show the value change, we use $")
    println("To show the value change, we use $$change")

    val numerator = 10.99
    val denominator = 20.00
    println("The value of $numerator divided by $denominator is ${numerator / denominator}")

    println("The employee´s id is ${employeeFive.id}")

}

class Employee(val id: Int, var name: String) {

    override fun equals(obj: Any?): Boolean {
        if(obj is Employee) {
            return name == obj.name && id == obj.id
        }
        return false
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Employee(id=$id, name='$name')"
    }


}