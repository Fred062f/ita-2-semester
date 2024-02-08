package com.example.tasks_intro

fun main() {
    /*
    val tom: Cat = Cat("Tom", 8, "Grey", "Jerry")
    val garfield: Cat = Cat("Garfield", 10, "Red", "Feed me")
    tom.meow(3)
    garfield.meow(5)

    val recipe: Recipe = Recipe("Pizza", listOf("Dough", "Tomato sauce", "Cheese"))
    recipe.display()

    val tinderProfile: TinderProfile = TinderProfile("John", 30)
    tinderProfile.bio = "I'm a software engineer who specialises in Kotlin Classes"
    tinderProfile.view()

    val drums: Instrument = Instrument("Bom Tak Bom Tak")
    drums.play()

    val lamp: Lamp = Lamp(Light.ON)
    println(lamp.light)
    lamp.toggleLight()
    println(lamp.light)

    val pokemon: Pokemon = Pokemon(5, 5, 5)
    pokemon.change("mood", 11)
    println(pokemon.mood)

     */
    val item1 = TodoItem("Buy groceries")
    val item2 = TodoItem("Clean the house")
    val item3 = TodoItem("Finish coding assignment")

    val todoList = TodoList()

    todoList.addItem(item1)
    todoList.addItem(item2)
    todoList.addItem(item3)

    todoList.displayItems()

    item1.isCheckedOut = true
    item2.isFavorited = true

    todoList.displayItems()

    todoList.removeItem(item3)

    todoList.displayItems()
}

/*
Create a Cat class. The class should have:
    4 attributes that you choose
    1 method that you choose
    Create 2 instances of cats using the constructor!
 */

class Cat(val name: String, val age: Int, val color: String, val sound: String = "Meow") {
    fun meow(number: Int) {
        for (n in 1..number) {
            println(this.sound)
        }
    }
}

/*
Create the classes modelling the following objects.
Add both some relevant attributes and some relevant
methods:
    Recipe
    A Tinder profile
    A musical instrument
 */

class Recipe(val name: String, val ingredients: List<String>) {
    fun display() {
        println("Recipe: $name")
        println("Ingredients: ")
        for (ingredient in ingredients) {
            println("  $ingredient")
        }
    }
}

class TinderProfile(val name: String, val age: Int, var bio: String = "") {
    fun view() {
        println("Name: $name")
        println("Age: $age")
        println("Bio: $bio")
    }
}

class Instrument(val sound: String) {
    fun play() {
        println(sound)
    }
}

/*
Skriv en klasse der hedder Lamp
Lamp har en boolean attribut der angiver om den er tændt eller slukket.
Når man laver et nyt lamp-objekt skal der være en constructor hvor man kan vælge om lampen som udgangspunkt er tændt eller slukket
Skriv en metode der hedder toggleLight, som tænder lampen hvis den er slukket, og slukker lampen hvis den er tændt.
Lav en klasse Room med en main-metode hvor du instantierer forskellige lampeobjekter (skrivebordslampe, sengelampe el. lign.) og tester om de virker som de skal
Lav en metode der returnerer antal gange lampen er togglet.
 */

enum class Light {
    ON,
    OFF;

    fun toggle(): Light {
        return if (this == ON) OFF else ON
    }
}

class Lamp(var light: Light) {
    fun toggleLight() {
        light = light.toggle()
    }
}

/*
Create a class Pokemon that has the attributes
mood, energy, and hunger, with a range of values
between 10 (maximum) and 0 (minimum)
 */

class Pokemon(var mood: Int, var energy: Int, var hunger: Int) {
    init {
        require(mood in 0..10 && energy in 0..10 && hunger in 0..10)
        { println("Attributes must be between 0 and 10") }
    }

    fun change(attribute: String, value: Int) {
        if (value !in 0..10) return println("Value must be between 0 and 10")

        if (attribute.lowercase() == "mood") {
            mood = value

        } else if (attribute.lowercase() == "energy") {
            energy = value
        } else if (attribute.lowercase() == "hunger") {
            hunger = value
        } else {
            println("$attribute is not a valid attribute")
        }
    }
}

/*
Create classes for a todolist app
 */

class TodoItem(val name: String) {
    var isCheckedOut: Boolean = false
    var isFavorited: Boolean = false
}

class TodoList {
    private val items = mutableListOf<TodoItem>()

    fun addItem(item: TodoItem) {
        items.add(item)
    }

    fun removeItem(item: TodoItem) {
        items.remove(item)
    }

    fun displayItems() {
        println("Todo List:")
        items.forEachIndexed { index, item ->
            println("Task ${index + 1}: ${item.name}, Checked out: ${item.isCheckedOut}, Favorited: ${item.isFavorited}")
        }
    }
}
