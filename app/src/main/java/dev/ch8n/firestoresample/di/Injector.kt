package dev.ch8n.firestoresample.di

import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.UserSource

object Injector {

    val firebaseManager: FirebaseManager = FirebaseManager()

    val userSource: UserSource = UserSource(firebaseManager)

}