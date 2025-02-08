package com.example.catalogoapp.src.viewCatalogo.presentation

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.catalogoapp.src.viewCatalogo.data.model.ViewCatalogoDTO
import com.example.catalogoapp.src.viewCatalogo.domain.TextoAVoz

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewCatalogoUi(viewModel: ViewCatalogoViewModel, navController: NavController) {
    val ropas by viewModel.ropas.collectAsState()
    LaunchedEffect(Unit) { viewModel.loadRopas() }

    // Definimos los nuevos colores: rojo y morado, igual que en el login.
    val primaryRed = Color(0xFFF44336)      // rojo brillante
    val secondaryPurple = Color(0xFF9C27B0)   // morado vibrante

    // Fondo degradado con los nuevos colores para toda la pantalla.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(primaryRed, secondaryPurple)
                )
            )
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Catalogo 2025", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = primaryRed),
                    actions = {
                        IconButton(onClick = { navController.navigate("create_ropa") }) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Agregar Ropa",
                                tint = Color.White
                            )
                        }
                        IconButton(onClick = { navController.navigate("login") }) {
                            Icon(
                                Icons.Default.ExitToApp,
                                contentDescription = "Cerrar sesión",
                                tint = Color.White
                            )
                        }
                    }
                )
            },
            containerColor = Color.Transparent, // Permite ver el fondo degradado.
            contentColor = Color.White
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(ropas) { ropa ->
                    RopasCard(ropa, primaryRed, secondaryPurple)
                }
            }
        }
    }
}

@Composable
fun RopasCard(ropa: ViewCatalogoDTO, primaryRed: Color, secondaryPurple: Color) {
    val context = LocalContext.current
    val textoAVoz = remember { TextoAVoz(context) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(24.dp), // Bordes más redondeados, al igual que en el login.
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.End)
                    .size(50.dp),
                onClick = {
                    textoAVoz.speak(
                        "Nombre: ${ropa.name}, Descripcion: ${ropa.description}, Precio: ${ropa.price},Talla: ${ropa.talla}"
                    )
                },
                contentPadding = PaddingValues(0.dp)
            ){
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Icono de play"
                )
            }
            Text(
                text = "Nombre: ${ropa.name}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = primaryRed
            )
            Text(
                text = "Descripción: ${ropa.description}",
                style = MaterialTheme.typography.bodyMedium,
                color = secondaryPurple
            )
            Text(
                text = "Precio: ${ropa.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = primaryRed
            )

            Text(
                text = "Talla: ${ropa.talla}",
                style = MaterialTheme.typography.bodyMedium,
                color = secondaryPurple
            )
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            textoAVoz.release()
        }
    }
}
