package com.example.projet.domain.usecase

import com.example.projet.data.repository.UserRepository
import com.example.projet.domain.entity.User





    class GetUserUseCase(private val userRepository: UserRepository) {

        suspend fun invoke(email: String) : User{

           return userRepository.getUser(email)

        }

}