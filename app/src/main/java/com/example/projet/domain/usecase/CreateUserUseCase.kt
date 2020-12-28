package com.example.projet.domain.usecase

import com.example.projet.data.repository.UserRepository
import com.example.projet.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {

    suspend fun invoke(user: User){

        userRepository.createUser(user)

    }
}