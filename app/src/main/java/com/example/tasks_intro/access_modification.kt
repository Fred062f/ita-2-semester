package com.example.tasks_intro

import java.time.LocalDate
import java.time.Period
import java.util.Date

fun main() {
    /*
    val bankAccount: BankAccount = BankAccount(12345)
    bankAccount.balance = -100.0
    println(bankAccount.balance)

     */
    val student: Student = Student("Ivan", LocalDate.parse("2018-12-12"))
    student.grade = 100
    println(student.grade)
    println(student.age)
}

/*
Create a Kotlin class called BankAccount with the following properties:
accountNumber: The account number of the bank account.
balance: The current balance of the bank account.
 */

class BankAccount(val accountNumber: Int) {
    private var _balance: Double = 0.0

    var balance: Double
        get() = _balance
        set(value) {
            _balance = if (value >= 0) value else 0.0
        }
}

/*
Create a class named Student to represent
student information....
 */

class Student(val name: String, val birthdate: LocalDate) {
    private var _grade: Int? = null

    var grade: Int?
        get() = _grade
        set(value) {
            if (value != null) {
                _grade = if (value in 1..99) value else null
            }
        }

    val age: Int
        get() {
            return Period.between(LocalDate.now(), birthdate).years
        }
}