package com.example.catalogoapp.src.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginUi(viewModel: LoginViewModel, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginSuccess by viewModel.loginSuccess

    // Definir los nuevos colores: rojo y morado
    val primaryRed = Color(0xFFF44336)      // rojo brillante
    val secondaryPurple = Color(0xFF9C27B0)   // morado vibrante

    // Fondo degradado que combina rojo y morado
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(primaryRed, secondaryPurple)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Tarjeta que contiene el formulario de inicio de sesión
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp), // Bordes más redondeados
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Ícono y título de bienvenida
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Logo",
                    tint = primaryRed,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Bienvenido a Catalogo-App",
                    style = MaterialTheme.typography.headlineSmall,
                    color = primaryRed
                )
                // Campo de texto para el usuario
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Usuario") },
                    modifier = Modifier.fillMaxWidth(),

                )
                // Campo de texto para la contraseña (enmascarada)
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                )
                // Botón de "Ingresar"
                Button(
                    onClick = { viewModel.loginUser(name, password) },
                    enabled = name.isNotEmpty() && password.isNotEmpty(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryRed),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Ingresar")
                }
                // Botón de "Crear Cuenta"
                OutlinedButton(
                    onClick = { navController.navigate("register") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = primaryRed),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Crear Cuenta")
                }
            }
        }
    }

    // Navegación al cambiar el estado de loginSuccess
    LaunchedEffect(loginSuccess) {
        if (loginSuccess == true) {
            navController.navigate("view_catalogo")
        }
        viewModel.resetLoginState()
    }
}
