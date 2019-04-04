package dev.ch8n.firestoresample.ui.register

import dev.ch8n.firestoresample.R
import dev.ch8n.firestoresample.base.BaseActivity
import dev.ch8n.firestoresample.data.models.User

class OnboardActivity : BaseActivity(), OnboardContract.View {

    override fun contentLayout(): Int = R.layout.activity_main

    lateinit var controller: OnboardController

    override fun setup() {
        controller = OnboardController(this)
        controller.createUser(
            User(
                name = "Chetan",
                username = "ch8n",
                email = "chetan.garg36@gmail.com",
                follows = emptyMap(),
                followers = emptyMap(),
                bio = "Yo yo chetu singh",
                uid = "foo"
            )
        )
    }

    override fun onError(userMessage: String) = toast(userMessage)

    override fun onSuccessUserCreated() {
        controller.getUser("foo")
    }

    override fun onSuccessUserData(user: User) {
        toast(user.toString())
    }

}
