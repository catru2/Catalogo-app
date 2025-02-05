package com.example.catalogoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catalogoapp.src.createRopa.data.datasource.RetrofitClientRopa
import com.example.catalogoapp.src.createRopa.data.repository.RopaRepository
import com.example.catalogoapp.src.createRopa.domain.CreateRopaUseCase
import com.example.catalogoapp.src.createRopa.presentation.CreateRopaUi
import com.example.catalogoapp.src.createRopa.presentation.RopaViewModel
import com.example.catalogoapp.src.login.data.datasource.RetrofitClientLogin
import com.example.catalogoapp.src.login.data.repository.LoginRepository
import com.example.catalogoapp.src.login.domain.LoginUseCase
import com.example.catalogoapp.src.login.presentation.LoginUi
import com.example.catalogoapp.src.login.presentation.LoginViewModel
import com.example.catalogoapp.src.register.data.datasource.RetrofitClient
import com.example.catalogoapp.src.register.data.repository.RegisterRepository
import com.example.catalogoapp.src.register.domain.CreateUserUseCase
import com.example.catalogoapp.src.register.presentation.RegisterUi
import com.example.catalogoapp.src.register.presentation.RegisterViewModel
import com.example.catalogoapp.src.viewCatalogo.data.datasource.RetrofitClientViewCatalogo
import com.example.catalogoapp.src.viewCatalogo.data.repository.ViewCatalogoRepository
import com.example.catalogoapp.src.viewCatalogo.domain.ViewCatalogoaUseCase
import com.example.catalogoapp.src.viewCatalogo.presentation.ViewCatalogoUi
import com.example.catalogoapp.src.viewCatalogo.presentation.ViewCatalogoViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // Registro
            val registerRepository = RegisterRepository(RetrofitClient.api)
            val registerViewModel = RegisterViewModel(
                CreateUserUseCase(registerRepository),
            )

            // Crear
            val ropaRepository = RopaRepository(RetrofitClientRopa.api)
            val createRopaViewModel = RopaViewModel(
                CreateRopaUseCase(ropaRepository)
            )

            // Login
            val loginRepository = LoginRepository(RetrofitClientLogin.api)
            val loginViewModel = LoginViewModel(
                LoginUseCase(loginRepository)
            )

            // Visualizar productos
            val viewCatalogoRepository = ViewCatalogoRepository(RetrofitClientViewCatalogo.api)
            val viewCatalogoViewModel = ViewCatalogoViewModel(
                ViewCatalogoaUseCase(viewCatalogoRepository)
            )

            // Navegacion
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginUi(viewModel = loginViewModel, navController)
                }
                composable("register") {
                    RegisterUi(viewModel = registerViewModel, navController)
                }
                composable("create_ropa") {
                    CreateRopaUi(viewModel = createRopaViewModel, navController)
                }
                composable("view_catalogo") {
                    ViewCatalogoUi(viewModel = viewCatalogoViewModel, navController)
                }
            }
        }
    }
}
