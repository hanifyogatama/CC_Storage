package com.binar.cc_storage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.memo_layout.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {

    private lateinit var db: MemoDatabase
    private lateinit var memo : Memo


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }

        MemoDatabase.getInstance(this)?.let {
            db = it
        }

        intent.getParcelableExtra<Memo>("memo")?.let {
            memo = it
        }

        // share prefered
        val sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("USERNAME", "")
        etUsername.setText(username)
        val email = sharedPreferences.getString("EMAIL", "")
        etEmail.setText(email)

        ivBack.setOnClickListener {
            val toMainMenuActivity = Intent(this, MainMenu::class.java)
            startActivity(toMainMenuActivity)
        }

        // add memo
        fabAddMemo.setOnClickListener {
            Log.d("Main", "button pressed")
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.input_layout, null)
            val etDate = dialogLayout.findViewById<EditText>(R.id.etDate)
            val etMemo = dialogLayout.findViewById<EditText>(R.id.etMemo)

            with(builder) {
                setTitle("Tambah Memo Kamu")
                setPositiveButton("tambah") { dialog, which ->

                    val objectMemo = Memo(
                        null,
                        etDate.text.toString(),
                        etMemo.text.toString()
                    )

                    GlobalScope.launch {
                        val result = db.memoDao().addItem(objectMemo)
                        runOnUiThread {
                            if (result > 0) {
                                // success
                                Toast.makeText(
                                    applicationContext,
                                    "Sukses menambahkan data ${objectMemo.isiMemo}",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "gagal menambahkan data ${objectMemo.isiMemo}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            finish()
                        }

                    }

                    // Toast.makeText(applicationContext, "text succesfully added", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("cancel") { dialog, which ->
                    Log.d("Main", "negative button pressed")
                }
                setView(dialogLayout)
                show()

            }
        }

    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData() {
        GlobalScope.launch {
            val listMemo = db?.memoDao()?.readAllItem()

            runOnUiThread {
                listMemo?.let {
                    val adapter = MemoAdapter(it)
                    val layoutManager =
                        LinearLayoutManager(
                            this@ProfileActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    recyclerView.layoutManager = layoutManager
                    recyclerView.adapter = adapter
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        MemoDatabase.destroyInstance()
    }
}