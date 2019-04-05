package dev.ch8n.firestoresample.data.models

import com.google.firebase.firestore.Exclude
import java.util.*

data class Post(
    val postId: String = "",
    val uid: String = "",
    val username: String = "",
    val imageUrl: String = "",
    val caption: String = "",
    val likes: Long = 0L,
    val comments: List<Comment> = emptyList(),
    val date: Date,
    @get:Exclude val id: String = ""
)