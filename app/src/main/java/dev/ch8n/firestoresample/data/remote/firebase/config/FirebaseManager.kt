package dev.ch8n.firestoresample.data.remote.firebase.config

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseManager {

    var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        private set

}