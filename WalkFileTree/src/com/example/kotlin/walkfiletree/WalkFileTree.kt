package com.example.kotlin.walkfiletree

import java.io.File


fun main(args: Array<String>) {

    // Starting at working directory
    // Because we are walking top-down the directories are visited before the files
    File(".").walkTopDown().forEach { println(it) }


    // Printing filtered files
    println()
    println("Printing only Kotlin files...")
    File(".").walkTopDown()
                       .filter { it.name.endsWith(".kt") }
                       .forEach { println(it) }
}