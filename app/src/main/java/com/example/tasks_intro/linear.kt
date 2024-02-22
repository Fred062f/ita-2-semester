package com.example.tasks_intro

fun main() {

    // First repeating element
    val input = arrayOf(10,5,4,6,3,5,3,2);
    var list: MutableList<Int> = mutableListOf()
    /*
    for (i in input.indices) {
        if (input[i] in list) {
            println(i)
            break
        } else {
            list.add(input[i])
        }
    }

     */
    /*
    for (i in input.indices) {
        if (list.size == 0) {
            list.add(input[i])
        } else {
            for (j in list) {
                if (input[i] == j) {
                    println(i)
                    break
                } else {
                    list.add(input[i])
                }
            }
        }
    }

     */
     firstLoop@ for (i in input.indices) {
        for (j in i + 1..input.lastIndex) {
            if (input[i] == input[j]) {
                println("$i, $j")
                break@firstLoop
            }
        }
    }
}

