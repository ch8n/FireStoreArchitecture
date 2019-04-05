package dev.ch8n.firestoresample.ui.register

import dev.ch8n.firestoresample.data.models.Post
import dev.ch8n.firestoresample.data.models.User


interface OnboardContract {

    interface View {
        fun onSuccessUserCreated()
        fun onError(userMessage: String)
        fun onSuccessUserData(user: User)
        fun onUploadSuccessful(postId: String)
    }

    interface Controller {
        fun onStart()

        fun createUser(user: User)
        fun onSuccessUserCreated()

        fun getUser(uId: String)
        fun onSuccessUserData(user: User)

        fun onError(message: String)
        fun onStop()

        fun uploadPost(post: Post)
        fun onImageUploadSuccess(post: Post)
        fun onPostPublishSuccess(post: Post)

    }

    interface Presenter {
        fun attach()
        fun deattach()


        fun createUser(user: User)
        fun getUser(uId: String)

        fun uploadImageCouldnary(post: Post)
        fun publishPost(post: Post)


    }
}