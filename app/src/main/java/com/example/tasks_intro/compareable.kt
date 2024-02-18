package com.example.tasks_intro

fun main() {
    /*
    val student1: Students = Students("John", null, 16, listOf("Math", "Chemistry"))
    val student2: Students = Students("Joan", null, 16, listOf("Math", "Biology", "English"))
    val student3: Students = Students("Juan", null, 20, listOf("History", "Psychology"))
    val list: List<Students> = listOf(student1, student2, student3)
    println(list.sorted())

     */
    val book1: Books = Books("Harry Potter 1", "J. K. Rowling", "12345", 220.0)
    val book2: Books = Books("Harry Potter 2", "J. K. Rowling", "54321", 220.0)
    val book3: Books = Books("Harry Potter 3", "J. K. Rowling", "101112", 250.0)
    val bookstore: Bookstore = Bookstore()
    bookstore.addBook(book2)
    println(bookstore.inventory)

}

/*
A. Write a class student.
Implement the comparable interface such that students can be sorted by age
 */

class Students(val name: String, val email: String?, val age: Int, val subject: List<String>): Comparable<Students> {
    override fun compareTo(other: Students): Int {
        if (this.age - other.age == 0) {
            return other.subject.size - this.subject.size
        }
        return this.age - other.age
    }

    override fun toString(): String {
        return "Name: $name, Age: $age, Subjects: ${subject.size}"
    }

}

/*
B. Create a data class named Book.
 */

data class Books(val title: String, val author: String, val isbn: String?, val price: Double) {
}

class Bookstore {
    var inventory: MutableList<Books> = mutableListOf()
    // Adds a book to the inventory.
    fun addBook(book: Books) {
        inventory.add(book)
    }

    // Removes a book from the inventory based on its ISBN.
    /*
    fun removeBook(isbn: String) {
        inventory.removeIf { book -> book.isbn == isbn }
    }

     */

}