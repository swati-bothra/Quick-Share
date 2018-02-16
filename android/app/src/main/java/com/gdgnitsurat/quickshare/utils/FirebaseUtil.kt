package com.gdgnitsurat.quickshare.utils

import android.provider.Settings
import android.util.Log
import com.gdgnitsurat.quickshare.model.Clip
import com.gdgnitsurat.quickshare.model.Device
import com.gdgnitsurat.quickshare.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseUtil {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseUser: FirebaseUser? = firebaseAuth.currentUser
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var deviceid :String = ""

    fun addCurrentUserToFirebaseDatabase(deviceID:String) {
        val databaseRef: DatabaseReference = database.getReference("users")
        val user = User(firebaseAuth.currentUser?.displayName, firebaseAuth.currentUser?.email, deviceID)
        databaseRef.child(firebaseAuth.currentUser?.uid).setValue(user)
    }

    fun addDevicesToFirebaseDatabase(deviceID:String) {
        deviceid = deviceID
        val databaseRef: DatabaseReference = database.getReference("devices")
        val device = Device("clips","android", firebaseAuth.currentUser?.uid)
        databaseRef.child(deviceID).setValue(device)
    }

    fun addClipsToFirebaseDatabase(clip:String,time:String) {
        val databaseRef: DatabaseReference = database.getReference("clips")
        val clip = Clip(deviceid,clip,time, firebaseAuth.currentUser?.uid)
        databaseRef.push().setValue(clip)
    }

    fun isUserSignedIn(): Boolean {
        firebaseUser = firebaseAuth.currentUser
        return firebaseUser != null
    }

}