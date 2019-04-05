package dev.ch8n.firestoresample.ui.register

import android.util.Log
import com.cloudinary.android.callback.ErrorInfo
import com.cloudinary.android.callback.UploadCallback
import dev.ch8n.firestoresample.data.models.Post
import dev.ch8n.firestoresample.data.models.User
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.UserSource
import dev.ch8n.firestoresample.data.remote.firebase.source.realtime.global.post.GlobalPostSource
import dev.ch8n.firestoresample.di.Injector


class OnboardPresenter(private val controller: OnboardContract.Controller) : OnboardContract.Presenter {


    override fun attach() {
        userSource = Injector.userSource
        globalPostSource = Injector.globalPostSource
    }

    override fun deattach() {
        userSource = null
        globalPostSource = null
    }

    private var userSource: UserSource? = null
    override fun createUser(user: User) {

        userSource?.run {
            createUser(user).addOnSuccessListener {
                controller.onSuccessUserCreated()
            }.addOnFailureListener {
                controller.onError(it.localizedMessage)
                Log.e("Onboarding:CreateUser", it.toString())
            }
        } ?: kotlin.run {
            controller.onError("UserSource not initalized OR null")
        }

    }

    override fun getUser(uId: String) {
        userSource?.run {
            getUser(uId).addOnSuccessListener { doc ->
                doc.toObject(User::class.java)?.also {
                    controller.onSuccessUserData(it)
                } ?: kotlin.run {
                    controller.onError("unable to cast users or error")
                }
            }.addOnFailureListener {
                controller.onError(it.localizedMessage)
                Log.e("Onboarding:CreateUser", it.toString())
            }
        } ?: kotlin.run {
            controller.onError("UserSource not initalized OR null")
        }
    }


    private var globalPostSource: GlobalPostSource? = null


    override fun uploadImageCouldnary(post: Post) {
        globalPostSource?.apply {
            uploadImageCloudinary(post.imageURI)
                .option("connect_timeout", 10000)
                .option("read_timeout", 10000)
                .callback(object : uploadHelper() {
                    override fun onError(requestId: String?, error: ErrorInfo?) {
                        controller.onError(error.toString())
                    }

                    override fun onSuccess(requestId: String?, resultData: MutableMap<Any?, Any?>?) {
                        val publicKey = requireNotNull(resultData?.get("public_id") as String?)
                        val imageUrl = requireNotNull(resultData?.get("secure_url") as String?)
                        val postClone = post.copy(postId = publicKey, imageUrl = imageUrl)
                        controller.onImageUploadSuccess(postClone)
                    }
                })
        } ?: kotlin.run {
            controller.onError("globalPostSource not initalized OR null")
        }
    }

    override fun publishPost(post: Post) {
        globalPostSource?.apply {
            publishPost(post).addOnSuccessListener {
                controller.onPostPublishSuccess(post)
            }
        } ?: kotlin.run {
            controller.onError("globalPostSource not initalized OR null")
        }
    }


}

abstract class uploadHelper : UploadCallback {
    override fun onSuccess(requestId: String?, resultData: MutableMap<Any?, Any?>?) {

    }

    override fun onProgress(requestId: String?, bytes: Long, totalBytes: Long) {
        val progress = bytes as Double / totalBytes
    }

    override fun onReschedule(requestId: String?, error: ErrorInfo?) {

    }

    override fun onError(requestId: String?, error: ErrorInfo?) {

    }

    override fun onStart(requestId: String?) {

    }
}