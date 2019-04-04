package dev.ch8n.firestoresample.ui.register

import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.models.User


interface OnboardContract {

    interface View {
        fun onSubmitUserDetails(user: User)
        fun onError(userMessage: String)
    }

    interface Controller {
        fun onStart()
        fun onError(message: String)
        fun onStop()
        fun onSuccessUserCreated()
    }

    interface Presenter {
        fun attach()
        fun createUser(uId: String, user: User)
        fun deattach()
    }
}