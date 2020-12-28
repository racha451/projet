package com.example.projet.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet.domain.entity.User
import com.example.projet.domain.usecase.CreateUserUseCase
import com.example.projet.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val createUserUseCase: CreateUserUseCase,
                    private val getUserUseCase: GetUserUseCase
                    ) : ViewModel(){


fun onClickedIncrement(emailUser: String){
    viewModelScope.launch(Dispatchers.IO){
        createUserUseCase.invoke(User("test"))
        delay(timeMillis = 1000)
        val user =getUserUseCase.invoke( "test")


    }

     }

         }
