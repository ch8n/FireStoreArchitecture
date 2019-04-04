package dev.ch8n.firestoresample.data.remote.firebase.config

object FirebaseApi {

    object FireStore {

        object Collection {
            const val USERS = "users"
            const val GLOBAL_POST = "global_posts"
        }

        object Documents {
            const val USER = "user_"
            const val GLOBAL_POST = "global_post"
        }

    }

    object Auth {

    }

    object Realtime {
        const val GLOBAL_POST = "global_post"
    }
}