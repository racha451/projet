package com.example.projet.data.repository

import com.example.projet.data.local.models.DatabaseDao
import com.example.projet.data.local.models.UserLocal
import com.example.projet.data.local.models.toData
import com.example.projet.data.local.models.toEntity
import com.example.projet.domain.entity.User

class UserRepository(private val databaseDao: DatabaseDao) {

    suspend fun createUser(user: User) {

        databaseDao.insert(user.toData())

    }

    fun getUser(email: String): User {

        val userLocal: UserLocal = databaseDao.findByName(email)
return userLocal.toEntity()
    }
}