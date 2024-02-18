package com.example.tasks_intro

import android.os.Build
import androidx.annotation.RequiresApi
import java.sql.Timestamp
import java.time.LocalDate

fun main() {
    /*
    val articles: ArrayList<Article> = arrayListOf(
        Article("Benjamin", "How to manipulate the DOM with JavaScript"),
        Article("Nicklas", "A demonstration of complex JOIN queries in SQL"),
        Article("Brian", "The importance of user research in UI/UX"),
        Article("Anders", "Working with workflows in GitHub"),
        Article("Frederik", "Life of a student at KEA"),
    )
    for (article in articles) {
        println(article)
    }

    /*
    Add some different Fastfood objects to an array.
    Now iterate through that array and use some of the
    methods you have created above.
     */
    val orders: ArrayList<FastFood> = arrayListOf(
        Sandwich(),
        Pizza(),
        Burger(),
        Sandwich()
    )
    for (order in orders) {
        println(order.order())
    }

    val cervelo: Vehicle = Bicycle()
    val canyon: Vehicle = Bicycle()
    cervelo.speedUp(10)
    canyon.changeGear(12)
    canyon.applyBrakes(10)

    val redditPost1: RedditPost = RedditPost("Benjamin", "How to manipulate the DOM with JavaScript")
    val redditPost2: RedditPost = RedditPost("Nicklas", "A demonstration of complex JOIN queries in SQL")
    val redditPost3: RedditPost = RedditPost("Brian", "The importance of user research in UI/UX")
    redditPost1.upvote()
    redditPost2.upvote()
    redditPost2.upvote()
    redditPost3.downvote()
    val redditFrontPage: RedditFrontPage = RedditFrontPage()
    redditFrontPage.list.add(redditPost1)
    redditFrontPage.list.add(redditPost2)
    redditFrontPage.list.add(redditPost3)
    redditFrontPage.delete(1)
    println(redditFrontPage.list.sorted())

     */
    val words = listOf("apple", "banana", "apple", "orange", "banana", "apple", "orange", "banana", "apple","banana", "apple", "orange", "banana","banana", "apple", "orange", "apple", "orange", "banana")
    println(frequency(words))
}

/*
1. Write a class: Article
Create 5 articles, add them into an ArrayList and
print them by overriding the .toString() method
 */

class Article(val author: String, val title: String) {
    override fun toString(): String {
        return "Author: $author, Title: $title"
    }
}

/*
2. Create an interface called FastFood (with
appropriate methods) and create a Sandwich class,
a Pizza class and a class you decide that
implements the FastFood interface.
 */

interface FastFood {
    fun order(): String
}

class Sandwich : FastFood {
    override fun order(): String {
        return "You Ordered Sandwich"
    }

}

class Pizza : FastFood {
    override fun order(): String {
        return "You Ordered Pizza"
    }

}

class Burger : FastFood {
    override fun order(): String {
        return "You Ordered Burger"
    }

}

/*
3. Create a class that implements the following
interface. Now create two objects using the class
created:
 */

internal interface Vehicle {
    fun changeGear(a: Int)
    fun speedUp(a: Int)
    fun applyBrakes(a: Int)
}

class Bicycle : Vehicle {
    override fun changeGear(a: Int) {
        println("Changing gear to $a")
    }

    override fun speedUp(a: Int) {
        println("Speeding up by $a km/h")
    }

    override fun applyBrakes(a: Int) {
        println("Applying brakes with intensity $a")
    }
}

/*
4. Write a class: RedditPost.
Ensure all attributes are private, but accesible by getters & setters.
 */

class RedditPost(
    private var _author: String,
    private var _title: String
) : Comparable<RedditPost> {

    @RequiresApi(Build.VERSION_CODES.O)
    private var _date: LocalDate = LocalDate.now()

    private var _upvotes: Int = 1
        set(value) {
            field = if (value >= 0) value else 0
        }

    private var _downvotes: Int = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    private val balance: Int
        get() {
            return _upvotes - _downvotes
        }

    var author: String
        get() = _author
        set(value) {
            _author = value
        }

    var title: String
        get() = _title
        set(value) {
            _title = value
        }

    var date: LocalDate
        @RequiresApi(Build.VERSION_CODES.O)
        get() = _date
        @RequiresApi(Build.VERSION_CODES.O)
        set(value) {
            _date = value
        }

    fun upvote() {
        _upvotes++
    }

    fun downvote() {
        _downvotes++
    }


    override fun compareTo(other: RedditPost): Int {
        return other.balance - this.balance
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun toString(): String {
        return "Author: $author\n" +
                "Title: $title\n" +
                "Date: $date\n" +
                "Balance: $balance\n\n"
    }
}

/*
4.5. Write a class: RedditFrontPage.
 */

class RedditFrontPage {
    var list: MutableList<RedditPost> = mutableListOf()
    /*
    A method in RedditFrontPage deletes a
    RedditPost from the list, by its index number
     */
    fun delete(index: Int) {
        list.removeAt(index)
    }
}

/*
Write a program that takes a list of words as input
and prints the frequency of each word.
 */

fun frequency(list: List<String>): MutableMap<String, Int> {
    val map: MutableMap<String, Int> = mutableMapOf()

    for (word in list) {
        map[word] = map.getOrDefault(word, 0) + 1
    }
    return map
}


