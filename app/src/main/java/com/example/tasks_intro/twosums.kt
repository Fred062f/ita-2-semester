package com.example.tasks_intro

fun main() {
    println(twoSum(intArrayOf(3, 2, 3), 6))
}

/*
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

 */

fun twoSum(nums: IntArray, target: Int): Pair<Any?, Int> {
    var hashMap: HashMap<Int, Int> = hashMapOf()
    for (i in nums.indices) {
        if ((target - nums[i]) in hashMap.keys) {
            return Pair(hashMap[target - nums[i]], i)
        } else {
            hashMap[nums[i]] = i
        }
    }
    return Pair(-1, -1)
}
