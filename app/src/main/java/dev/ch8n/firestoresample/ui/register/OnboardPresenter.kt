package dev.ch8n.firestoresample.ui.register

import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.UserSource
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.models.User
import dev.ch8n.firestoresample.di.Injector

class OnboardPresenter(private val controller: OnboardContract.Controller) : OnboardContract.Presenter {

    private var userSource: UserSource? = null

    override fun attach() {
        userSource = Injector.userSource
    }

    override fun createUser(uId: String, user: User) {
        userSource?.run {
            createUser(uId, user).addOnSuccessListener {
                controller.onSuccessUserCreated()
            }.addOnFailureListener {
                controller.onError(it.localizedMessage)
            }
        } ?: kotlin.run {
            controller.onError("UserSource not initalized OR null")
        }
    }

    override fun deattach() {
        userSource = null
    }

}