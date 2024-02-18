package com.example.tasks_intro

import android.media.Image
import android.provider.MediaStore
import java.sql.Timestamp
import java.util.Objects

fun main() {
    val text: Methods = Text(null, "User1", null, 0)

    val cms = ContentManagementSystem()
    cms.collection.addAll(listOf(text))

    cms.search("uploader")
}

// Create functionality for an Instagram-like Service.
interface Posts {
    val caption: String?
    val uploader: String
    val timestamp: Timestamp?
    var likes: Int
}

abstract class Methods : Posts {
    fun getLikes() {
        println("Likes: $likes")
    }

    fun like() {
        likes++
    }

    fun dislike() {
        likes--
    }
}

class Text(
    override val caption: String?,
    override val uploader: String,
    override val timestamp: Timestamp?,
    override var likes: Int = 0
) : Methods() {

}

class Photo(
    override val caption: String,
    override val uploader: String,
    override val timestamp: Timestamp?,
    override var likes: Int = 0,
    val photo: Image,
    val resolution: Int,
    val filters: String?
) : Posts {
}

class Video(
    override val caption: String,
    override val uploader: String,
    override val timestamp: Timestamp?,
    override var likes: Int = 0,
    val video: MediaStore.Video,
    val length: Int,
    val resolution: Int
) : Posts {
}

/*
 A Content Management System (CMS) should be
 designed to manage the different types of posts.
 */

class ContentManagementSystem {
    var collection = mutableListOf<Posts>()
    fun search(criteria: String) {
        print("Search by $criteria: ")
        val search = readln()

        for (post in collection) {
            println(post)
        }
            /*
            if (post[criteria] == search) {
                println(post)
            } else {
                println("Not found")
            }
        }

         */
    }
}




