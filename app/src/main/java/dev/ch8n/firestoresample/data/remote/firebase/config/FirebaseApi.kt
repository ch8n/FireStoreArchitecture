package dev.ch8n.firestoresample.data.remote.firebase.config

object FirebaseApi {

    object FireStore {

        object Collection {
            const val ALL_USERS = "all_users"
            const val ALL_POST = "all_posts"
            const val PROFILE = "profile"
        }

        object Documents {
            const val USER = "user"
        }

    }

    object Auth {

    }

    object Realtime {
        const val GLOBAL_POST = "global_post"
    }
}