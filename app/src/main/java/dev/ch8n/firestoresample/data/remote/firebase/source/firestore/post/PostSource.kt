package dev.ch8n.firestoresample.data.remote.firebase.source.firestore.post

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import dev.ch8n.firestoresample.data.models.Post
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseApi
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager

class PostSource private constructor(private val firebaseManager: FirebaseManager) {

    companion object {

        @Volatile
        private var instance: PostSource? = null

        fun getInstance(firebaseManager: FirebaseManager) = instance ?: synchronized(this) {
            instance ?: PostSource(firebaseManager).also { instance = it }
        }

    }

    private val firebaseStore by lazy { firebaseManager.firestore }

    fun createPost(post: Post): Task<Void> = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.ALL_USERS)
        .document(post.uid)
        .collection(FirebaseApi.FireStore.Collection.ALL_POST)
        .document(post.postId)
        .set(post)

    fun getPost(userid: String, postId: String): Task<DocumentSnapshot> = firebaseStore
        .collection(FirebaseApi.FireStore.Collection.ALL_USERS)
        .document(userid)
        .collection(FirebaseApi.FireStore.Collection.ALL_POST)
        .document(postId)
        .get()

}