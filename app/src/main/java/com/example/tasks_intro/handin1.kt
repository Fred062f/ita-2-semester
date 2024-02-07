package com.example.tasks_intro

fun main() {
    /*
    println(isEligible())
    println(getMax(1,18,8))
    println(getMin(1,18,-8))
    println(calculateAverage(listOf(5, 10, 15, 20)))
    println(isValidCPRNumber())
    fizzBuzz()
    abbreviation("Robert Brett Roser")
    println(calculateGrade(79))
    println(filterWordsByLength(listOf<String>("Dog", "Cat", "Tiger", "Elephant", "Spider"), 3))
     */
    println(isValidISBN("3-598-21508-8"))
}

/*
1. A person is elligible to vote if his/her age is greater
than or equal to 18. Define a method to find out if
he/she is elligible to vote. Let the user input their
age. Get inspiration in the terminal output below:
 */

fun isEligible(): String {
    print("Please enter your age: ")
    val age: Int = readln().toInt()
    return if (age >= 18) {
        "You are eligible to vote"
    } else {
        "You are not eligible to vote"
    }
}

/*
2. Define two functions to print the maximum and the
minimum number respectively among three numbers
 */

fun getMax(a: Int, b: Int, c: Int): Int {
    return maxOf(a, b, c)
}

fun getMin(a: Int, b: Int, c: Int): Int {
    return minOf(a, b, c)
}

/*
3. Write a Kotlin function named calculateAverage
that takes in a list of numbers and returns their
average.
 */

fun calculateAverage(list: List<Int>): Float {
    var sum: Int = 0
    for (n: Int in list) {
        sum += n
    }
    return sum.toFloat()/list.size
}

/*
4. Write a method that returns if a user has input a valid
CPR number.
 */

fun isValidCPRNumber(): Boolean {
    print("Please enter a valid CPR number: ")
    val number: String = readln()
    val pattern: Regex = Regex("^(?:[0-2][0-9]|3[0-1])(?:0[1-9]|1[0-2])\\d{6}\$")
    return pattern.matches(number)
}

/*
5. Write a program that prints the numbers from 1 to
100. But for multiples of three print “Fizz” instead of
the number and for the multiples of five print “Buzz”.
For numbers which are multiples of both three and
five print “FizzBuzz”.
 */

fun fizzBuzz() {
    for (number: Int in 1..100) {
        if (number % 3 == 0 && number % 5 == 0) {
            println("FizzBuzz")
        } else if (number % 5 == 0) {
            println("Buzz")
        } else if (number % 3 == 0) {
            println("Fizz")
        } else {
            println(number)
        }
    }
}

/*
6. Write a program that takes your full name as input
and displays the abbreviations of the first and middle
names except the last name which is displayed as it is
 */

fun abbreviation(name: String) {
    val list: List<String> = name.split(" ")
    println("${list[0][0]}.${list[1][0]}. ${list[2]}")
}

/*
Write a program that takes a numerical grade (0-100)
as input and prints out the corresponding american
letter grade. Implement a function
calculateGrade that takes an integer parameter
representing the grade and returns a string
representing the letter grade according to the
following scale:
 */

fun calculateGrade(grade: Int): String {
    when (grade) {
        in 90..100 ->  return "A"
        in 80..89 -> return "B"
        in 70..79 -> return "C"
        in 60..69 -> return "D"
        in 0..60 -> return "F"
    }
    return "Program takes a numerical grade (0-100)"
}

/*
8. Write a Kotlin function named
filterWordsByLength that takes in a list of
strings and a minimum length, and returns a list
containing only the words that have a length greater
than or equal to the specified minimum length.
 */

fun filterWordsByLength(list: List<String>, min: Int): List<String> {
    return list.filter { it.length > min }
}

/*
Advanced (Optional). Given a string the program should
check if the provided string is a valid ISBN-10.
 */

fun isValidISBN(string: String): Boolean {
    val pattern: Regex = Regex("^(?:\\d{1,5}-\\d{1,7}-\\d{1,6}-[\\dX])|\\d{9}[\\dX]\$")
    if (pattern.matches(string)) {
        val list: List<Int> = string.replace("-", "").map { if (it.isDigit()) it.digitToInt() else 10 }
        return ((list[0] * 10 + list[1] * 9 + list[2] * 8 + list[3] * 7 + list[4] * 6 + list[5] * 5 + list[6] * 4 + list[7] * 3 + list[8] * 2 + list[9] * 1) % 11 == 0)
    }
    return false
}