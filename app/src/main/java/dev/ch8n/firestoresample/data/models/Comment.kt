package dev.ch8n.firestoresample.data.models

import com.google.firebase.firestore.Exclude
import java.util.*

data class Comment(
    val uid: String = "",
    val username: String = "",
    val photo: String? = null,
    val text: String = "",
    val date: Date,
    @get:Exclude val id: String = ""
)