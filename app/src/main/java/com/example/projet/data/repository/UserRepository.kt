package com.example.projet.data.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.projet.data.local.models.AppDatabase
import com.example.projet.data.local.models.DatabaseDao
import com.example.projet.data.local.models.UserLocal


class UserRepository (application: Application){

private var daoAccess: DatabaseDao? = null
private var allData: LiveData<List<UserLocal>>? = null

    init {
        //fetching user database
        val db = AppDatabase.getDatabase(application)
        daoAccess = db?.databaseDao()
        allData = daoAccess?.getDetails()

    }


fun getAllData(): LiveData<List<UserLocal>>? {
    return allData
}

fun insertData(data: UserLocal) {
    daoAccess?.let { LoginInsertion(it).execute(data) }
}

private class LoginInsertion(private val daoAccess: DatabaseDao) :
    AsyncTask<UserLocal, Void, Void>() {

    override fun doInBackground(vararg data: UserLocal): Void? {

        daoAccess.insertUserData(data[0])
        return null

    }

}
}