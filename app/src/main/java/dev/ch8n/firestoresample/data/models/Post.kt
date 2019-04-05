package dev.ch8n.firestoresample.data.models

import android.net.Uri
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.FieldValue

data class Post(
    val postId: String = "",
    val uid: String = "",
    val username: String = "",
    val imageUrl: String = "",
    @get:Exclude val imageURI: Uri,
    val caption: String = "",
    val likes: Long = 0L,
    val comments: List<Comment> = emptyList(),
    val date: FieldValue = FieldValue.serverTimestamp()
)