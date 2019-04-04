package dev.ch8n.firestoresample.data.remote.firebase.config

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseManager {

    var auth: FirebaseAuth = FirebaseAuth.getInstance()
        private set

    var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        private set

}