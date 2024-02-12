package com.example.tasks_intro

fun main() {
    /*
    val dog: Dog = Dog("Pluto", 4, true)
    val pig: Pig = Pig("Gurli", 4, true)
    val listOfAnimals: List<Animal> = listOf(dog, pig)
    for (animal in listOfAnimals) {
        println(animal.makeSound())
    }
    println(dog)

     */
    val appetizer: Appetizer = Appetizer("Bitterballen", "Dutch meat-based snack", 8)
    println(appetizer.cook())
}

/*
Write a class called Animal.
 */

open class Animal(val name: String, val nrOfLegs: Int, val isMammal: Boolean) {
    open fun makeSound() {
        println("Animal Sound")
    }

    override fun toString(): String {
        return this.name + " " + this.nrOfLegs + " " + this.isMammal
    }
}

class Dog(name: String, nrOfLegs: Int, isMammal: Boolean): Animal(name, nrOfLegs, isMammal) {
    override fun makeSound() {
        println("Woof")
    }
}

class Pig(name: String, nrOfLegs: Int, isMammal: Boolean): Animal(name, nrOfLegs, isMammal) {
    override fun makeSound() {
        println("Øfff")
    }
}

/*
Create a hierarchy of food items in a restaurant
menu. Implement a base class called FoodItem with
properties name, description, and price.
 */

open class FoodItem(val name: String, val description: String, val price: Int) {
    fun cook() {
        println("$name is currently being cooked")
    }
}

class Appetizer(name: String, description: String, price: Int): FoodItem(name, description, price) {
    val servingSize: Int = 2
}

class MainCourse(name: String, description: String, price: Int): FoodItem(name, description, price) {
    val spicinessLevel : Int = 6
}

class Dessert(name: String, description: String, price: Int): FoodItem(name, description, price) {
    val isVegan: Boolean = false
}