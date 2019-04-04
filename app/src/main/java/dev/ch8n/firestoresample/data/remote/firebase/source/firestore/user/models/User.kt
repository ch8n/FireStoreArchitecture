package dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.models

import com.google.firebase.firestore.Exclude

data class User(
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val follows: Map<String, Boolean> = emptyMap(),
    val followers: Map<String, Boolean> = emptyMap(),
    val bio: String? = null,
    val photo: String? = null,
    @Exclude val uid: String = ""
)