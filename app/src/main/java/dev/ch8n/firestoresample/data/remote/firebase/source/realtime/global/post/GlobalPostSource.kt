package dev.ch8n.firestoresample.data.remote.firebase.source.realtime.global.post

import com.google.android.gms.tasks.Task
import dev.ch8n.firestoresample.data.models.Post
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseApi
import dev.ch8n.firestoresample.data.remote.firebase.config.FirebaseManager

class GlobalPostSource(firebaseManager: FirebaseManager) {

    private val realtime by lazy { firebaseManager.realtime.reference }

    fun getPushKey(): String = requireNotNull(realtime.child(FirebaseApi.Realtime.GLOBAL_POST).push().key)

    fun publishPost(post: Post): Task<Void> {
        return realtime.child(FirebaseApi.Realtime.GLOBAL_POST).child(post.postId).setValue(post)
    }


}