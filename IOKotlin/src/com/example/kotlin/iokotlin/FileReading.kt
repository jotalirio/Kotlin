package com.example.kotlin.iokotlin

import java.io.File


fun main(args: Array<String>) {

    // Kotlin does not have its own IO classes so what is done is it has basically extension functions onto the existing
    // Java IO classes so when we do IO in Kotlin we are always using the IO classes in the JDK. Package 'kotlin.io'

    // In this case we do not specify the directory path because the file is inside the working directory
    // .reader() is an extension function over the File class


//    In Java the equivalent code would be: new InputStreamReader(new FileInputStreamReader(new File("testfile.txt")), "UTF-8");
    val lines1 = File("testfile.txt").reader().readLines()
    lines1.forEach { println(it) }
    println()


    // Closing the stream when we use .reader().readText()
    val reader = File("testfile.txt").reader()
    val lines2 = reader.readText()
    println(lines2)
    reader.close()


    // Another way to close the resources. The 'use' function close the streams for us, in this case the resource is the reader
    val lines3 = File("testfile.txt").reader().use { it.readText() }
    println(lines3)


    // Using the BufferReader
    val lines4 = File("testfile.txt").bufferedReader().use { it.readText() }
    println(lines4)


    // There is another version of .readText() that will close the resource. In this case the .readText() function is an extension function
    // of File class
    val lines5 = File("testfile.txt").readText()
    println(lines5)

    // This looks really similar to what we did with .readLines() but instead of reading the entire file in one shot
    // it is going to read a line at a time
    File("testfile.txt").reader().forEachLine { println(it) }


    // The .forEachLine() is using implicitly the .useLines { it } to close the resource
    // We can use .useLines { it } directly
    // The first 'it' references the sequences and the second one is printing this sequence
//    println()
//    File("testfile.txt").reader().useLines { it.forEach { println(it) } }
}