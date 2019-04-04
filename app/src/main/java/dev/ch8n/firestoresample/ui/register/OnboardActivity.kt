package dev.ch8n.firestoresample.ui.register

import dev.ch8n.firestoresample.R
import dev.ch8n.firestoresample.base.BaseActivity
import dev.ch8n.firestoresample.data.remote.firebase.source.firestore.user.models.User

class OnboardActivity : BaseActivity(), OnboardContract.View {

    override fun contentLayout(): Int = R.layout.activity_main

    lateinit var controller: OnboardController

    override fun setup() {
        controller = OnboardController(this)
    }

    override fun onError(userMessage: String) = toast(userMessage)

    override fun onSubmitUserDetails(user: User) {

    }

}
