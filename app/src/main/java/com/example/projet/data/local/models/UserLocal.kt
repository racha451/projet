package com.example.projet.data.local.models
import androidx.room.Dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable



@Entity
 class UserLocal : Serializable {
        //declaration of user table columns
        @PrimaryKey(autoGenerate = true)

        var id: Int = 0

       var email: String? = null

        var username: String? = null



        var password: String? = null


}