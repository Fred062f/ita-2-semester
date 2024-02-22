package com.example.tasks_intro

fun main() {
    println(twoSum(intArrayOf(3, 3), 6))
}

fun twoSum(nums: IntArray, target: Int): String {
    for (i in nums.indices) {
        for (j in nums.indices) {
            if (i != j) {
                if (nums[i] + nums[j] == target) {
                    return "$i, $j"
                }
            }
        }
    }
    return "False"
}