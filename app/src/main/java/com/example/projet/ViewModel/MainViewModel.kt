package com.example.projet.ViewModel


import com.example.projet.data.local.models.UserLocal
import com.example.projet.data.repository.UserRepository


import androidx.lifecycle.LiveData
import android.app.Application
import androidx.lifecycle.AndroidViewModel

import androidx.annotation.NonNull



class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: UserRepository
    private var getAllDatas: LiveData<List<UserLocal>>

    init {

        repository = UserRepository(application)
        getAllDatas = repository.getAllData()!!
    }

    fun insert(data: UserLocal) {
        repository.insertData(data)
    }
    fun getGetAllData(): LiveData<List<UserLocal>> {
        return getAllDatas
    }
}
