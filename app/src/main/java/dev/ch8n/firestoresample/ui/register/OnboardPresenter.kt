package dev.ch8n.firestoresample.ui.register

import android.util.Log
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.UserSource
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.models.User
import dev.ch8n.firestoresample.di.Injector


class OnboardPresenter(private val controller: OnboardContract.Controller) : OnboardContract.Presenter {

    private var userSource: UserSource? = null

    override fun attach() {
        userSource = Injector.userSource
    }

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
            getUser(uId).addOnSuccessListener {
                val user = it.toObject(User::class.java)
                controller.onSuccessUserCreated()
            }.addOnFailureListener {
                controller.onError(it.localizedMessage)
                Log.e("Onboarding:CreateUser", it.toString())
            }
        } ?: kotlin.run {
            controller.onError("UserSource not initalized OR null")
        }

    }


    override fun deattach() {
        userSource = null
    }

}