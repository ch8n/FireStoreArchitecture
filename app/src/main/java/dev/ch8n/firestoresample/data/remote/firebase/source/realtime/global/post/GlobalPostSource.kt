package dev.ch8n.firestoresample.data.remote.firebase.source.realtime.global.post

import android.net.Uri
import com.cloudinary.android.MediaManager
import com.google.android.gms.tasks.Task
import dev.ch8n.firestoresample.data.models.Post
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseApi
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager

class GlobalPostSource private constructor(
    private val firebaseManager: FirebaseManager
) {

    companion object {

        @Volatile
        private var instance: GlobalPostSource? = null

        fun getInstance(firebaseManager: FirebaseManager) = instance ?: synchronized(this) {
            instance ?: GlobalPostSource(firebaseManager).also { instance = it }
        }

    }


    private val realtime by lazy { firebaseManager.realtime.reference }

    fun uploadImageCloudinary(fileURI:Uri) = MediaManager.get().upload(fileURI)

    fun publishPost(post: Post): Task<Void> {
        return realtime.child(FirebaseApi.Realtime.GLOBAL_POST).child(post.postId).setValue(post)
    }



}