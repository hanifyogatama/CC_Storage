package com.binar.cc_storage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {

    val username = "ervin"
    val password = "ervin123"
    val email = "ervin@binar.co.id"
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }

        preferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

//        if (preferences.contains("username")) {
//            val intent = Intent(this, MainMenu::class.java)
//            startActivity(intent)
//            finish()
//        }

        btnLogin.setOnClickListener {
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)
            editor.putString("EMAIL", email)
            editor.apply()

            if (etUsername.text.toString() == username && etPassword.text.toString() == password) {

                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
                finish()
            } else {
                Snackbar.make(it, "username / password salah", Snackbar.LENGTH_LONG).show()
            }
        }

    }
}