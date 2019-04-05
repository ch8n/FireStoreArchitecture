package dev.ch8n.firestoresample

import android.app.Application
import com.cloudinary.android.MediaManager

class FireStoreApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MediaManager.init(this, hashMapOf(Pair("cloud_name","myCloudName")))

    }
}