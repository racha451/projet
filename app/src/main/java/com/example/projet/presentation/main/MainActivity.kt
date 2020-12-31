

package com.example.projet.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.projet.R
import com.example.projet.ViewModel.MainViewModel
import com.example.projet.data.local.models.UserLocal
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class MainActivity : AppCompatActivity() {
    /**
     * @param isExist  bool parameter for check existency of user or not in database
     */
    var isExist = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //calling view mdioel object
        val userRepository = ViewModelProvider(this).get(MainViewModel::class.java)

        btn_register1.setOnClickListener {
            val intent = Intent(this@MainActivity, SignupActivity::class.java)
            // start your next activity
            startActivity(intent)
        }


        btn_login1.setOnClickListener {
            if (validation()) {


                userRepository.getGetAllData()
                    .observe(this, object : Observer<List<UserLocal>> {
                        override fun onChanged(t: List<UserLocal>) {
                            var userObject = t

                            for (i in userObject.indices) {
                                if (userObject[i].email?.equals(email_btn.text.toString())!!) {

                                    if (userObject[i].password?.equals(password_btn.text.toString())!!) {

                                        val intent =
                                            Intent(this@MainActivity, ApiActivity::class.java)
                                                .putExtra("UserDetials", userObject[i])
                                        // start your next activity
                                        startActivity(intent)

                                    } else {
                                        Toast.makeText(
                                            this@MainActivity,
                                            " Password is Incorrect ",
                                            Toast.LENGTH_LONG
                                        )
                                            .show()
                                    }
                                    isExist = true
                                    break

                                } else {
                                    isExist = false
                                }
                            }

                            if (isExist) {




                            } else {

                                Toast.makeText(
                                    this@MainActivity,
                                    " User Not Registered ",
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                        }

                    })




            }}}


    fun validation(): Boolean {
        if (email_btn.text.isNullOrEmpty()) {
            Toast.makeText(this@MainActivity, " Enter Full Name ", Toast.LENGTH_LONG).show()
            return false
        }


        if (password_btn.text.isNullOrEmpty()) {
            Toast.makeText(this@MainActivity, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
    }


