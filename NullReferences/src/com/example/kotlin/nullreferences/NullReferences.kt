package com.example.kotlin.nullreferences



fun main(args: Array<String>) {

    val str1: String? = "This is not null"
    // str.toUpperCase() // At this point this method is not allowed because str can be null
    if (str1 != null) {
        str1.toUpperCase() // Here the compiler remember that we have already check that str != null so we can apply .toUpperCase() function
    }

    // Equivalent to the above code using safe access expression ?
    str1?.toUpperCase()

    // Forcing to be null
    val str2: String? = null
    // If the safe access expression evaluates it to null then return null but if not return the proper value
    println("What happens when we do this: ${str2?.toUpperCase()}")

    // This is what the safe operator is doing:
    if (str2 == null) {
        null
    }
    else {
        str2.toUpperCase()
    }


    // Imagine the next Java code:
//    if (bankBranch != null) {
//        Address address = bankBranch.getAddress();
//        if (address != null) {
//            Country country = address.getCountry();
//            if (country != null) {
//                String countryCode = country.getCountryCode();
//            }
//        }
//    }

    // Let´s do it the same with a only one Kotlin line code
    // At the moment one of the safe operators evaluates to null, the expression will evaluate to null
    // val countryCode: String? = bankBranch?.address?.country?

    // The ELVIS operator lets you assign a default value when an expression evaluates to null
    // val countryCode: String? = bankBranch?.address?.country?.countryCode ?: "US"

    // Here the compiler knows that this str3 variable cannot be null because we are using the ELVIS operator assigning a default value when str2 is null
    // REMINDER: Kotlin best practice is not to declare nullable types unless you absolutely have to
    val str3 = str2 ?: "This is the default value"
    println(str3)

    // This is what the ELVIS operator is doing:
//    if (str2 == null) {
//        str3 = "This is the default value"
//    }
//    else {
//        str3 = str2
//    }

    // Safe cast operator: if it turns out that you cannot perform the cast successfully, the cast evaluates to null
    val something: Any = arrayOf(1, 2, 3, 4)
    val str4 = something as? String // Returns a nullable String (String?)
    println(str4)
    println(str4?.toUpperCase())


    // Not null assertion
    val str5: String? = null
    val str6 = str5!!.toUpperCase()

    // This is what the not null assertion operator is doing:
//    if (str5 == null) {
//        throw Kotlin.KotlinNullPointerException
//    }
//    else {
//        str5.toUpperCase()
//    }

    // The 'let' function: If str5 is not null (that is the safe operator) then let this function (printText(it)) call go ahead
    // and we are referring to the variable with the safe operator, inside the block of the expression (the lambda expression) that follows the let word
    // using the keyword 'it'
    str5?.let { printText(it) }

    // Structural equal operator is null safe
    val str7: String? = null
    val anotherStr = "This is not nullable"
    println(str4 == anotherStr)

}

fun printText(text: String) {
    println(text)
}