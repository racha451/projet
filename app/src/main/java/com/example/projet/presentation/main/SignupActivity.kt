package com.example.projet.presentation.main


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.projet.R
import com.example.projet.ViewModel.MainViewModel
import com.example.projet.data.local.models.AppDatabase
import com.example.projet.data.local.models.UserLocal
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

/**
 * Created by Akash Kumar on 4/17/2020.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
class SignupActivity : AppCompatActivity() {

    var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        //calling view mdioel object
        val userDetailsRepository = ViewModelProvider(this@SignupActivity).get(MainViewModel::class.java)

        btn_login.setOnClickListener {
            val intent = Intent(this@SignupActivity, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        btn_register.setOnClickListener {
            if (validation()) {
                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<UserLocal>> {
                    override fun onChanged(t: List<UserLocal>) {
                        var userObject = t

                        for (i in userObject.indices) {


                            if (userObject[i].email?.equals(bt_email.text.toString())!!) {
                                isExist = true
                                //Toast.makeText(this@SignupActivity," User Already Registered ", Toast.LENGTH_LONG).show()
                                break

                            } else {
                                isExist = false
                                continue

                            }
                        }

                        if (isExist) {
                            Toast.makeText(this@SignupActivity, " User Already Registered !!! ", Toast.LENGTH_LONG)
                                .show()

                        } else {

                            val user = UserLocal()
                            user.username = bt_username.text.toString()
                            user.email = bt_email.text.toString()
                            user.password = bt_password.text.toString()
                            val userDatabase = AppDatabase
                            userDatabase.getDatabase(this@SignupActivity)?.databaseDao()?.insertUserData(user)
                            Toast.makeText(this@SignupActivity, " User  Registered Successfully", Toast.LENGTH_LONG)
                                .show()


                        }

                    }

                })
            }

        }


    }

    /**
     * Attempts to register in  the account specified by the registration form.
     * If there are form errors (invalid name, missing fields, etc.), the
     * errors are presented in form of toast and no actual login attempt is made.
     */
    private fun validation(): Boolean {
        if (bt_username.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter Full Name ", Toast.LENGTH_LONG).show()
            return false
        }


        if (bt_password.text.isNullOrEmpty()) {
            Toast.makeText(this@SignupActivity, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

}