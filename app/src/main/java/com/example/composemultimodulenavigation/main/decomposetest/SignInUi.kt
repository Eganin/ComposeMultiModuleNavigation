package com.example.composemultimodulenavigation.main.decomposetest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composemultimodulenavigation.ui.theme.ComposeMultiModuleNavigationTheme
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun SignInUi(component: SignInComponent, modifier: Modifier = Modifier) {

    val login by component.login.collectAsState()
    val password by component.password.collectAsState()
    val inProgress by component.inProgress.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Enter", fontSize = 36.sp, modifier = Modifier.padding(all = 16.dp))

        OutlinedTextField(
            value = login,
            onValueChange = component::onLoginChanged,
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            label = { Text(text = "Login") },
            shape = RoundedCornerShape(size = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = component::onPasswordChanged,
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(size = 8.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        if (inProgress) {
            CircularProgressIndicator()
        } else {
            Button(
                onClick = component::onSignInClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
            ) {
                Text(text = "Sign in")
            }
        }

    }
}

class FakeSignComponent : SignInComponent {

    override val login = MutableStateFlow(value = "login")
    override val password = MutableStateFlow(value = "pass")
    override val inProgress = MutableStateFlow(value = false)

    override fun onLoginChanged(login: String) = Unit

    override fun onPasswordChanged(password: String) = Unit

    override fun onSignInClick() = Unit

}


@Preview(showSystemUi = true,showBackground = true)
@Composable
fun SignInUiPreview() {
    ComposeMultiModuleNavigationTheme {
        SignInUi(component = FakeSignComponent())
    }
}