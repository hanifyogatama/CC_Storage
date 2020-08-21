package com.binar.cc_storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.binar.cc_storage.databinding.ActivityPlayerVsCompBinding
import kotlin.system.exitProcess

class PlayerVsPlayer : AppCompatActivity() {
    lateinit var binding: ActivityPlayerVsCompBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        binding = ActivityPlayerVsCompBinding.inflate(layoutInflater)

        val view = binding.root

        var pilihan=""
        var pilihanCom=""

       //binding.tvComputer.setText("Pemain 2")

        binding.rockPemain.setOnClickListener{
            pilihan = "batu"
            Log.d("pilihan user", pilihan)

            binding.rockPemain.isClickable = false
            binding.scissorsPemain.isClickable = false
            binding.paperPemain.isClickable = false

            binding.rockPemain.setBackgroundResource(R.drawable.card)

            binding.rockKomputer.setOnClickListener{
                pilihanCom = "batu"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.rockKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.draw)
                Log.d("hasil pertandingan", "Seimbang")
            }

            binding.scissorKomputer.setOnClickListener {
                pilihanCom = "gunting"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.scissorKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.pemain_menang)
                Log.d("hasil pertandingan", "Pemain Menang")
            }

            binding.paperKomputer.setOnClickListener {
                pilihanCom = "kertas"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.paperKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.komputer_menang)
                Log.d("hasil pertandingan", "Computer Menang")
            }
        }

        binding.scissorsPemain.setOnClickListener {
            pilihan = "gunting"
            Log.d("pilihan user", pilihan)

            binding.rockPemain.isClickable = false
            binding.scissorsPemain.isClickable = false
            binding.paperPemain.isClickable = false

            binding.scissorsPemain.setBackgroundResource(R.drawable.card)

            binding.rockKomputer.setOnClickListener{
                pilihanCom = "batu"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.rockKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.komputer_menang)
                Log.d("hasil pertandingan", "Computer Menang")
            }

            binding.scissorKomputer.setOnClickListener {
                pilihanCom = "gunting"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.scissorKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.draw)
                Log.d("hasil pertandingan", "Seimbang")
            }

            binding.paperKomputer.setOnClickListener {
                pilihanCom = "kertas"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.paperKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.pemain_menang)
                Log.d("hasil pertandingan", "Pemain Menang")
            }
        }

        binding.paperPemain.setOnClickListener {
            pilihan = "kertas"
            Log.d("pilihan user", pilihan)

            binding.rockPemain.isClickable = false
            binding.scissorsPemain.isClickable = false
            binding.paperPemain.isClickable = false

            binding.paperPemain.setBackgroundResource(R.drawable.card)

            binding.rockKomputer.setOnClickListener{
                pilihanCom = "batu"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.rockKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.pemain_menang)
                Log.d("hasil pertandingan", "Pemain Menang")
            }

            binding.scissorKomputer.setOnClickListener {
                pilihanCom = "gunting"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.scissorKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.komputer_menang)
                Log.d("hasil pertandingan", "Computer Menang")
            }

            binding.paperKomputer.setOnClickListener {
                pilihanCom = "kertas"
                Log.d("pilihan user 2", pilihanCom)

                binding.rockKomputer.isClickable = false
                binding.scissorKomputer.isClickable = false
                binding.paperKomputer.isClickable = false

                binding.paperKomputer.setBackgroundResource(R.drawable.card)
                binding.ivVersus.setImageResource(R.drawable.draw)
                Log.d("hasil pertandingan", "Seimbang")
            }
        }

        binding.refresh.setOnClickListener {
            binding.rockPemain.isClickable = true
            binding.scissorsPemain.isClickable = true
            binding.paperPemain.isClickable = true

            binding.paperKomputer.setBackgroundResource(0)
            binding.rockKomputer.setBackgroundResource(0)
            binding.scissorKomputer.setBackgroundResource(0)

            binding.paperPemain.setBackgroundResource(0)
            binding.rockPemain.setBackgroundResource(0)
            binding.scissorsPemain.setBackgroundResource(0)

            binding.ivVersus.setImageResource(R.drawable.ic_versus)
        }

        binding.home.setOnClickListener {
            finish()
        }

        binding.close.setOnClickListener {
            moveTaskToBack(true)
            exitProcess(1)
        }

        setContentView(view)
    }
}