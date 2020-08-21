package com.binar.cc_storage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        ivPerson.setOnClickListener {
            val toProfileActivity = Intent(this, ProfileActivity::class.java)
            startActivity(toProfileActivity)
        }

        val sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("USERNAME", "")
        tvNama.text=username

    }
}