package dev.ch8n.firestoresample.ui.register

import android.util.Log
import dev.ch8n.firestoresample.data.models.Post
import dev.ch8n.firestoresample.data.models.User

class OnboardController(private val view: OnboardContract.View) : OnboardContract.Controller {

    private val presenter: OnboardContract.Presenter = OnboardPresenter(this)

    override fun onStart() {
        presenter.attach()
    }

    override fun createUser(user: User) = presenter.createUser(user)
    override fun onSuccessUserCreated() = view.onSuccessUserCreated()

    override fun getUser(uId: String) = presenter.getUser(uId)
    override fun onSuccessUserData(user: User) = view.onSuccessUserData(user)


    override fun uploadPost(post: Post) = presenter.uploadImageCouldnary(post)
    override fun onImageUploadSuccess(post: Post) = presenter.publishPost(post)

    override fun onPostPublishSuccess(post: Post) {

    }


    override fun onError(message: String) {
        Log.e("OnboadingController", message)
        view.onError(message)
    }

    override fun onStop() {
        presenter.deattach()
    }


}