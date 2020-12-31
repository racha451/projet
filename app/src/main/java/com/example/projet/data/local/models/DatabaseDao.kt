package com.example.projet.data.local.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DatabaseDao {
    @Insert
    fun insertUserData(userLocal: UserLocal)  //   query is written above for insert all details of user

    @Query("select * from UserLocal")
    fun getDetails(): LiveData<List<UserLocal>> //   query is written above for fetching all details of user



}