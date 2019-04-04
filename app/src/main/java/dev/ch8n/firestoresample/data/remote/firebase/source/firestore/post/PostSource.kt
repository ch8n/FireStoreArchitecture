package dev.ch8n.firestoresample.data.remote.firebase.source.firestore.post

import com.google.android.gms.tasks.Task
import dev.ch8n.firestoresample.data.models.Post
import dev.ch8n.firestoresample.data.models.User
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseApi
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager

class PostSource(private val firebaseManager: FirebaseManager) {

    private val firebaseStore by lazy { firebaseManager.firestore }

    fun uploadPost(post: Post): Task<Void> = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.POSTS)
        .document("${FirebaseApi.FireStore.Documents.USER}${uid}")
            .set(user)

    fun getUser(postId: String) = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.USERS)
        .document("${FirebaseApi.FireStore.Documents.USER}$uId")
        .get()


}