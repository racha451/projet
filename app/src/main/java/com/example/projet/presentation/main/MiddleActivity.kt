package com.example.projet.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.projet.R
import com.example.projet.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_api.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_middle.*


class MiddleActivity : AppCompatActivity() {
    /**
     * @param isExist  bool parameter for check existency of user or not in database
     */
    var isExist = false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle)


        btnre.setOnClickListener {
            val intent = Intent(this@MiddleActivity, ApiActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

    }
    }