package dev.ch8n.firestoresample.data.models

import com.google.firebase.firestore.Exclude

data class User(
    val name: String = "name",
    val username: String = "username",
    val email: String = "email",
    val photo: String? = null,
    val postIds: List<String> = emptyList<String>(),
    @Exclude val uid: String = ""
)