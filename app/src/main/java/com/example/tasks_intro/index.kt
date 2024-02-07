package com.example.tasks_intro

import javax.security.auth.callback.Callback
import kotlin.random.Random

fun main() {
    println(largest(100, 400, 800))
    println(isPalindrome("Anna"))
    println(sum(3, 2, 3))
    println(nearest(18, 2))
    println(filterNumbers(listOf(5, 10, 15, 20)))
    println(filterStrings(arrayOf("Frederik", "Max", "Emil", "Jonathan", "Nico")))
    println(fahrenheitToCelcius(listOf(32, 40, 50, 60, 70, 80)))
    higherOrderFunction("hello", 3) { s, n -> print(s.repeat(n)) }
    println()
    higherOrderFunction("hello", 3) { s, n -> print("${s[0]}".repeat(n)) }
    println()
    println(average(roll()))
}

// Write a function that receives 3 numbers as arguments and returns the largest of the numbers
fun largest(a: Int, b: Int, c: Int): Int {
    if (a > b) {
        if (a > c) {
            return a
        }
        else {
            return c
        }
    }
    else {
        if (b > c) {
            return b
        }
        else {
            return c
        }
    }
}

// Write a program that takes a String input from the user and outputs whether it is a palindrome or not
// The string should not contain whitespaces
fun isPalindrome(string: String): Boolean {
    return string.replace(" ", "").lowercase() == string.reversed().lowercase()
}

// Write a function that given 3 int values, a b c, return their sum.
// If one of the values is the same as another of the values, it does not count towards the sum.
fun sum(a: Int, b: Int, c:Int): Int {
    val numbers: MutableList<Int> = mutableListOf<Int>(a, b, c)
    val empty: MutableList<Int> = mutableListOf<Int>()
    var sum: Int = 0
    for (number in numbers) {
        if (number !in empty) {
            empty.add(number)
            sum += number
        }
    }
    return sum
}

// Write a function that recieves 2 int values greater than 0. Return whichever value is nearest to 21 without going over. Return 0 if they both go over.
fun nearest(a: Int, b: Int): Int {
    if (a > 21 && b > 21) {
        return 0
    }
    if (a == 21) {
        return a
    }
    if (b == 21) {
        return b
    }
    if (21 - a < 21 - b) {
        return a
    }
    else {
        return b
    }
}

// Write a function that uses the filter function to filter all numbers of a list greater than 10
fun filterNumbers(list: List<Int>): List<Int> {
    return list.filter { it > 10 }
}

// Write a function that takes an array of strings and returns an array with each strings length - if the strings has a length above 5 otherwise return 0 on the index.
fun filterStrings(array: Array<String>): List<Int> {
    return array.map { if (it.length > 5) 0 else it.length}
}

// Write a function that takes a list of degrees in fahrenheit and returns and array with each degree in celcius.
fun fahrenheitToCelcius(list: List<Int>): List<Double> {
    return list.map { (it - 32)/1.8 }
}

// Write your own higher order function (A function that takes a function as argument)
// The higher order function takes 3 parameters: a string s, a number n and a function
// Use the higher order function with 2 lambda functions:
fun higherOrderFunction(s: String, n: Int, function: (String, Int) -> Unit): Unit {
    function(s, n)
}

// Write a dice function that generates and returns a random number between 1-6.
fun dice(): Int {
    return Random.nextInt(1, 7)
}

// Write another function that uses the dice function to roll an amount of times decided by the user.
// The functions returns the dice rolls as a list
fun roll(): List<Int> {
    print("How many times do you want to roll the dice? ")
    val n: Int = readln().toInt()
    val list: MutableList<Int> = mutableListOf<Int>()
    for (roll in 1..n) {
        list.add(dice())
    }
    return list
}

// Write a function that takes the dice rolls as a parameter and returns the average
fun average(callback: List<Int>): Int {
    val list: List<Int> = callback
    var sum = 0
    for (number: Int in list) {
        sum += number
    }
    println(list)
    return sum/list.size
}