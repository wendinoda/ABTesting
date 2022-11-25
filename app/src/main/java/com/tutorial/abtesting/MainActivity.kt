package com.tutorial.abtesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.installations.FirebaseInstallations
import com.tutorial.abtesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseInstallations.getInstance().getToken(true)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Installations", "Installation auth token: " + task.result?.token)
                } else {
                    Log.e("Installations", "Unable to get Installation auth token")
                }
            }

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
    }
}