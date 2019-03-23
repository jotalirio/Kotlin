package com.example.kotlin.imports

import com.example.kotlin.inheritance.CompanyCommunications
import com.example.kotlin.inheritance.topLevel


fun main(args: Array<String>) {

    topLevel("Hello from AnotherFile")
    println(CompanyCommunications.getCopyrightLineBis())
}