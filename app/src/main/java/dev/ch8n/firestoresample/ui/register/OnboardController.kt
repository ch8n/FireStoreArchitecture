package dev.ch8n.firestoresample.ui.register

class OnboardController(private val view: OnboardContract.View) : OnboardContract.Controller {

    private val presenter: OnboardContract.Presenter = OnboardPresenter(this)

    override fun onStart() {
        presenter.attach()
    }

    override fun onError(message: String) {

    }

    override fun onStop() {
        presenter.deattach()
    }

    override fun onSuccessUserCreated() {

    }
}