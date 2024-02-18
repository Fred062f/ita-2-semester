package com.example.tasks_intro

import java.util.ArrayList

fun main() {
    val array: MutableList<String> = arrayListOf("Andreas", "Frederik", "Emil", "Jonathan")
    println(longestStrings(array))
}

/*
A. Write a function that takes an array of strings and returns the
indices NOT the number of the top 2 longest strings of the array.
 */

fun longestStrings(s: MutableList<String>): Pair<Int, Int> {
    var map: MutableMap<Int, Int> = mutableMapOf()

    for (i in s.indices) {
        map += Pair(i, s[i].length)
    }

    val sorted = map.entries.sortedBy { it.value }

    return Pair(sorted.reversed()[0].key, sorted.reversed()[1].key)
}

/*
Write a basic dictionary using a HashMap.
The keys will represent words and the values will be descriptions
of the words
 */

