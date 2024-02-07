package com.example.tasks_intro

fun main() {

    // Create a variable called age (no reassignment!)
    val age: Int = 22;

    // Create another variable called height
    val height: Int = 181;

    // Create the variable shoeSize and assign it to be your shoesize
    val shoeSize: Int = 42;

    // Create a variable called name and assign this to your name
    val name: String = "Frederik";

    var rectangleHeight: Double = 8.5;
    var rectangleWidth: Double = 5.5;
    println(perimeter(rectangleHeight, rectangleWidth))

    // Convert a string to uppercase
    val s: String = "string";
    println(s.uppercase())

    // Get the character on index 3
    // Print the index of a character in the string
    println(s[3])

    // Concatenate two different string
    val s1: String = "Hello";
    val s2: String = "World";
    println(s1 + " " + s2)

    // Check these strings are equal to each other. Uppercases should be ignored!
    println(isEqual("hello", "ollhe"))
    println(isEqual("bike", "banana"))
    println(isEqual("name", "NaMe"))
    println(isEqual("yes", "yes"))

    // Create a Map that contains the numberplate of a car and that cars color
    val car: Map<String, String> = mapOf("numberplate" to "AB 12345", "color" to "red")
    println(car)

    // Create a List. Add some prices to the List
    val list: List<Int> = listOf(1, 2, 3, 4, 5)

    // Use the function to find the second largest integer of the List created above
    //println(secondLargest(list))
    println(secondLargest(list))

    //println(prompt())

    calculator(25, 5)
}

// Create a function that computes the area and the perimeter of the rectangle and print the results
fun perimeter(height: Double, width: Double): String {
    return "Perimeter: ${2 * (height + width)}, Area: ${height * width}"
}

// Check these strings are equal to each other. Uppercase should be ignored!
fun isEqual(s1: String, s2: String): Boolean {
    return s1.uppercase() == s2.uppercase()
}

// Now create a function that takes a List of integers and returns the second largest integer in that array
fun secondLargest(list: List<Int>): Int {
    return (list.sortedDescending())[1]
}

// Create a function that prompts the user to provide a number, computes the half of the number and prints the result with a friendly message
fun prompt(): String {
    print("Please enter a number: ")
    val number: String = readln()
    return "This is the half of the number: ${(number.toDouble())/2}"
}

// Write a Kotlin function that accepts two integers from the user and then prints
fun calculator(a: Int, b: Int) {
    println("Sum of two integers: ${a + b}")
    println("Difference of two integers: ${a - b}")
    println("Product of two integers: ${a * b}")
    println("Average of two integers: ${(a + b) / 2}")
    println("Distance of two integers: ${if (a > b) a - b else b - a}")
    println("Max integer: ${if (a > b) a else b}")
    println("Min integer: ${if (a > b) b else a}")
}