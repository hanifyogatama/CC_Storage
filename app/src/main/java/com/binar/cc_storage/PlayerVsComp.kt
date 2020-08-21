package com.binar.cc_storage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PlayerVsComp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_vs_comp)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }



    }
}