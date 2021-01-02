package com.example.projet.presentation.main


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projet.R
import kotlinx.android.synthetic.main.activity_api.*


class ApiActivity : AppCompatActivity() {

    var isExist = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        btn_api.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",67)
            this.startActivity(intent)
        }


        btn_api1.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",670)
            this.startActivity(intent)
        }
        btn_api2.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",74)
            this.startActivity(intent)
        }
        btn_api3.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",80)
            this.startActivity(intent)
        }


        btn_api4.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",21)
            this.startActivity(intent)
        }

        btn_api5.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",33)
            this.startActivity(intent)
        }


        btn_api6.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",34)
            this.startActivity(intent)
        }

        btn_api7.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",77)
            this.startActivity(intent)

        }

        btn_api8.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",78)
            this.startActivity(intent)
        }

        btn_api9.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",79)
            this.startActivity(intent)
        }

        btn_api8.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",70)
            this.startActivity(intent)
        }

        btn_api9.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",80)
            this.startActivity(intent)
        }

        btn_api9.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",45)
            this.startActivity(intent)
        }

        btn_api10.setOnClickListener {
            val intent = Intent(this, SingleCompany::class.java)
            intent.putExtra("id",56)
            this.startActivity(intent)




        }

       }}

