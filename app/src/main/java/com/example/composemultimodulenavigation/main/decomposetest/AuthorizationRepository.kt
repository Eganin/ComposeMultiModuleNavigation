package com.example.composemultimodulenavigation.main.decomposetest

interface AuthorizationRepository {

    suspend fun signIn(login: String, password: String): Boolean

    class Base : AuthorizationRepository {
        override suspend fun signIn(login: String, password: String): Boolean =
            login.isNotEmpty() && password.isNotEmpty()
    }
}