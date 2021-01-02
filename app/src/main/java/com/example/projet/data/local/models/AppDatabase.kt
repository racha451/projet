package com.example.projet.data.local.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(UserLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
    companion object {

        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase? {

            if (INSTANCE == null) synchronized(AppDatabase::class.java) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                            context, AppDatabase::class.java, "USER_DATABASE"
                    ).allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()

                }

            }

            return INSTANCE

        }
    }
}