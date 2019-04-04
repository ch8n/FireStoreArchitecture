package dev.ch8n.firestoresample.ui.register

import dev.ch8n.firestoresample.data.models.User


interface OnboardContract {

    interface View {
        fun onSuccessUserCreated()
        fun onError(userMessage: String)
        fun onSuccessUserData(user: User)
    }

    interface Controller {
        fun onStart()

        fun createUser(user: User)
        fun onSuccessUserCreated()

        fun getUser(uId: String)
        fun onSuccessUserData(user: User)

        fun onError(message: String)
        fun onStop()

    }

    interface Presenter {
        fun attach()
        fun createUser(user: User)
        fun getUser(uId: String)
        fun deattach()
    }
}