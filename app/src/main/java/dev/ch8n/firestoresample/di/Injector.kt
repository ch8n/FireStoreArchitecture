package dev.ch8n.firestoresample.di

import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.UserSource
import dev.ch8n.firestoresample.data.remote.firebase.source.realtime.global.post.GlobalPostSource

object Injector {

    val firebaseManager: FirebaseManager = FirebaseManager()

    val userSource: UserSource = UserSource(firebaseManager)
    val globalPostSource: GlobalPostSource = GlobalPostSource(firebaseManager)

}