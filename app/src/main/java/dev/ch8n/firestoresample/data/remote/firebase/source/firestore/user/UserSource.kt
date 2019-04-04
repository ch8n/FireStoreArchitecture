package dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user

import com.google.android.gms.tasks.Task
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseApi
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.models.User

class UserSource(private val firebaseManager: FirebaseManager) {

    private val firebaseStore by lazy { firebaseManager.firestore }

    fun createUser(user: User): Task<Void> = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.USERS)
        .document("${FirebaseApi.FireStore.Documents.USER}${user.uid}")
            .set(user)

    fun getUser(uId: String) = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.USERS)
        .document("${FirebaseApi.FireStore.Documents.USER}$uId")
        .get()


}