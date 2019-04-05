package dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user

import com.google.android.gms.tasks.Task
import dev.ch8n.firestoresample.data.models.User
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseApi
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager

class UserSource private constructor(private val firebaseManager: FirebaseManager) {

    companion object {

        @Volatile
        private var instance: UserSource? = null

        fun getInstance(firebaseManager: FirebaseManager) = instance ?: synchronized(this) {
            instance ?: UserSource(firebaseManager).also { instance = it }
        }

    }

    private val firebaseStore by lazy { firebaseManager.firestore }

    fun createUser(user: User): Task<Void> = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.ALL_USERS)
        .document(user.uid)
        .collection(FirebaseApi.FireStore.Collection.PROFILE)
        .document(FirebaseApi.FireStore.Documents.USER)
        .set(user)

    fun getUser(uId: String) = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.ALL_USERS)
        .document(uId)
        .collection(FirebaseApi.FireStore.Collection.PROFILE)
        .document(FirebaseApi.FireStore.Documents.USER)
        .get()

}