package com.example.composemultimodulenavigation.main.decomposetest

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface SignInComponent {

    val login: StateFlow<String>

    val password: StateFlow<String>

    val inProgress: StateFlow<Boolean>

    fun onLoginChanged(login: String)

    fun onPasswordChanged(password: String)

    fun onSignInClick()
}

class RealSignInComponent(
    componentContext: ComponentContext,
    private val authorizationRepository: AuthorizationRepository,
) : ComponentContext by componentContext, SignInComponent {

    override val login = MutableStateFlow(value = "")
    override val password = MutableStateFlow(value = "")
    override val inProgress = MutableStateFlow(value = false)

    override fun onLoginChanged(login: String) {
        this.login.value = login
    }

    override fun onPasswordChanged(password: String) {
        this.password.value = password
    }

    override fun onSignInClick() {
        componentCoroutineScope().launch {
            inProgress.value = true
            authorizationRepository.signIn(login = login.value, password = password.value)
            inProgress.value = false
        }
    }

}

fun ComponentContext.componentCoroutineScope(): CoroutineScope {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    if (lifecycle.state != Lifecycle.State.DESTROYED) {
        lifecycle.doOnDestroy {
            scope.cancel()
        }
    } else {
        scope.cancel()
    }

    return scope
}