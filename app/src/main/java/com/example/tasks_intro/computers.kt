package com.example.tasks_intro

fun main() {
    val mobile: Computers = Mobile("iPhone 15", 1799, mapOf("Copenhagen" to 50.5))
    val raspberriPi: Computers = RaspberriPi("RP1", 250, mapOf("Aalborg" to 50.5))
    mobile.printLocation()
    raspberriPi.printLocation()

}

public interface Computers {
    val name: String;
    val price: Int;
    val location: Map<String, Double>;
    fun printLocation();
}

class Mobile(
    override val name: String,
    override val price: Int,
    override val location: Map<String, Double>
): Computers {
    override fun printLocation() {
        println("Location: ${location.keys}")
    }

}

class RaspberriPi(
    override val name: String,
    override val price: Int,
    override val location: Map<String, Double>
): Computers {
    override fun printLocation() {
        println("Location: $location")
    }
}