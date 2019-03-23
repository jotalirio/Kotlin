package com.example.kotlin.imports

import com.example.kotlin.inheritance.Department.IT
import com.example.kotlin.inheritance.Department.SALES
import com.example.kotlin.inheritance.CompanyCommunications as Comm
import com.example.kotlin.inheritance.topLevel as tp
import com.example.kotlin.inheritance.upperFirstAndLast as ufal


// FIRST OF ALL: Whe to add the 'Inheritance' module as a dependency.
// For that, Select Settings Module-> Select 'AnotherModule' -> Symbol '+' and add the 'Inheritance' module as dependy of 'AnotherModule' module
fun main(args: Array<String>) {

    tp("Hello from AnotherModuleFile")
    println(Comm.getCopyrightLine())
    println(IT.getDeptInfo())
    println(SALES.getDeptInfo())
    println("some string".ufal())

}