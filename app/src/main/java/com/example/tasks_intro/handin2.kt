package com.example.tasks_intro

fun main() {
    /*
    // Create two Employee objects and display each object’s yearly salary.
    val employee1: Employee = Employee("John", "Johnson", 6500.0)
    val employee2: Employee = Employee("Rob", "Robinson", 5000.0)

    println("${employee1.firstName}'s Yearly Salary: ${employee1.salary * 12} $")
    println("${employee2.firstName}'s Yearly Salary: ${employee2.salary * 12} $")

    // Then give each Employee a 10% raise and display each Employee’s yearly salary again.
    employee1.raiseSalary()
    employee2.raiseSalary()
    println("${employee1.firstName}'s Yearly Salary After Raise: ${employee1.salary * 12} $")
    println("${employee2.firstName}'s Yearly Salary After Raise: ${employee2.salary * 12} $")

    val laptop: Laptop = Laptop("Apple", "MacBook Pro", 1799.00)
    laptop.display()
    laptop.RAM = 16
    println(laptop.RAM)
    laptop.code()

    println("\n")

    val smartPhone: SmartPhone = SmartPhone("Apple", "iPhone 15", 799.00)
    smartPhone.display()
    smartPhone.buy(2)
    smartPhone.call("911")
    smartPhone.contacts = mutableListOf("48474546", "+45 24563740")
    smartPhone.contacts.add("007")
    println(smartPhone.contacts)

    val shoe: Shoe = Shoe("Shoe", 150.0, 2)
    shoe.identifyProductCategory()

    val circle = Circle( "Red", true, 2.5)
    println("Circle Perimeter: ${circle.calculatePerimeter()}, Area: ${circle.calculateArea()}")

    val rectangle = Rectangle("Blue", false, 10.0, 5.0)
    println("Rectangle Perimeter: ${rectangle.calculatePerimeter()}, Area: ${rectangle.calculateArea()}")

    val triangle = Triangle("Green", true, 3.0, 4.0, 5.0, 10.0, 5.0)
    println("Triangle Perimeter: ${triangle.calculatePerimeter()}, Area: ${triangle.calculateArea()}")

     */
    AutoShop().main()

}

/*
1. Create a class called Employee that includes three
pieces of information as instance variables.
 */

class Employee(val firstName: String, val lastName: String, salary: Double) {
    var salary: Double = if (salary > 0.0) salary else 0.0
        set(value) {
            field = if (value > 0.0) value else 0.0
        }
    fun raiseSalary() {
        this.salary = this.salary * 1.1
    }
}

/*
2. Create a new class called Computer. Before you
add any more code, know that you will need to add
two additional classes: Laptop and SmartPhone
 */

// For a parent class add 3 properties, 2 methods, and a constructor.
open class Computer(val brand: String, val model: String, val price: Double) {
    fun display() {
        println("Brand: ${brand}\nModel: ${model}\nPrice: ${price} $")
    }
    fun buy(quantity: Int) {
        println("Successful purchase of ${brand} ${model} for ${price * quantity} $")
    }

}

// For a child class add at least 1 additional property and 1 additional method.
class Laptop(brand: String, model: String, price: Double): Computer(brand, model, price) {
    var RAM: Int? = null
    fun code() {
        println("Coding in Kotlin...")
    }
}

class SmartPhone(brand: String, model: String, price: Double): Computer(brand, model, price) {
    var contacts: MutableList<String> = mutableListOf()
    fun call(number: String) {
        println("Calling $number....")
    }
}

/*
3. Create a base class Product with attributes like
name, price, and quantity and a function
identifyProductCategory. Subclass it to create
specific product types like Shoe, T-shirt, and
Book.
 */

open class Product(val name: String, val price: Double, val quantity: Int) {
    open fun identifyProductCategory() {
        println("I am a product")
    }
}

class Shoe(name: String, price: Double, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a shoe")
    }
}

class Book(name: String, price: Double, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a Book")
    }
}

class Tshirt(name: String, price: Double, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a T-shirt")
    }
}

/*
4. Create 3 classes Circle, Rectangle & Triangle with a
parent class: Shape.
 */

abstract class Shape(val color: String, val isTransparent: Boolean) {
    abstract fun calculatePerimeter(): Double
    abstract fun calculateArea(): Double
}

// Furthermore every class has private attributes to calculate perimeter and area for each shape.
// The 3 classes all overrides the following abstract methods from their parent class:
class Circle(color: String, isTransparent: Boolean, val radius: Double): Shape(color, isTransparent) {
    override fun calculatePerimeter(): Double {
        return 2 * radius * Math.PI
    }

    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(color: String, isTransparent: Boolean, val height: Double, val width: Double): Shape(color, isTransparent) {
    override fun calculatePerimeter(): Double {
        return 2 * (height + width)
    }

    override fun calculateArea(): Double {
        return height * width
    }
}

class Triangle(
    color: String,
    isTransparent: Boolean,
    val a: Double,
    val b: Double,
    val c: Double,
    val height: Double,
    val width: Double
    ): Shape(color, isTransparent) {
    override fun calculatePerimeter(): Double {
        return a + b + c
    }

    override fun calculateArea(): Double {
        return 0.5 * height * width
    }
}

/*
Optional. Auto-shop.
 */

// Create a super class called Car. The Car class has the following fields and methods.
open class Car(val speed: Int, val regularPrice: Double, val color: String) {
    open fun getSalePrice(): Double {
        return regularPrice
    }
}

// Create a sub class of Car class and name it as Truck. The Truck class has the following fields and methods.
class Truck(speed: Int, regularPrice: Double, color: String, val weight: Int): Car(speed, regularPrice, color) {
    override fun getSalePrice(): Double {
        return if (weight > 2000) regularPrice * 0.9 else regularPrice * 0.8
    }
}

// Create a subclass of Car class and name it as Ford. The Ford class has the following fields and methods
class Ford(speed: Int, regularPrice: Double, color: String, val year: Int, val manufacturerDiscount: Boolean? = null): Car(speed, regularPrice, color) {
    override fun getSalePrice(): Double {
        return if (manufacturerDiscount != null) regularPrice * 0.5 else regularPrice
    }
}

// Create AutoShop class which contains the main() method. Perform the following within the main() method.
class AutoShop {
    fun main() {
        // Create an instance of Truck class and initialize all the fields with appropriate values.
        val truck = Truck(60, 30000.0, "Grey", 2000)
        println("Truck Sale Price: ${truck.getSalePrice()} $")

        // Create two instances of the Ford class and initialize all the fields with appropriate values.
        val ford1 = Ford(99, 150000.0, "Red", 2024)
        val ford2 = Ford(30, 8000.0, "Silver", 2013, true)
        println("Ford 1 Sale Price: ${ford1.getSalePrice()} $ ")
        println("Ford 2 Sale Price: ${ford2.getSalePrice()} $")

        // Create an instance of Car class and initialize all the fields with appropriate values.
        val car = Car(55, 20000.0, "Black")
        println("Car Sale Price: ${car.getSalePrice()} $")
    }
}