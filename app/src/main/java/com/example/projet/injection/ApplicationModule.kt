package com.example.projet.injection

import android.content.Context
import androidx.room.Room
import com.example.projet.data.local.models.AppDatabase
import com.example.projet.data.local.models.DatabaseDao
import com.example.projet.data.repository.UserRepository
import com.example.projet.domain.entity.User
import com.example.projet.domain.usecase.CreateUserUseCase
import com.example.projet.domain.usecase.GetUserUseCase
import com.example.projet.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


val presentationModule : Module = module {
        factory{ MainViewModel(get(),get()) }
}



val domainModule : Module = module {
        factory { CreateUserUseCase(get()) }
        factory { GetUserUseCase(get()) }

}


val dataModule : Module = module {
        single { UserRepository(get()) }
        single { createDataBase(androidContext()) }



}


fun createDataBase(context: Context): DatabaseDao {


        val appDatabase:AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
        ).build()
        return  appDatabase.databaseDao()
}