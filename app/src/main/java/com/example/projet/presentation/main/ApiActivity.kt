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
            intent.putExtra("id",67 )
            this.startActivity(intent)
        }
    }}

