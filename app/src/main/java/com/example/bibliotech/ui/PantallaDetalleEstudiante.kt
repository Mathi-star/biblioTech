package com.example.bibliotech.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bibliotech.model.Estudiante

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetalleEstudiante(
    estudiante: Estudiante,
    onRegresar: () -> Unit,
    navController: NavController,
    onEditar: (Int) -> Unit,
    onEliminar: (Estudiante) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val mensaje = backStackEntry
        ?.savedStateHandle
        ?.get<String>("mensaje")

    LaunchedEffect(mensaje) {
        if (mensaje != null) {
            snackbarHostState.showSnackbar(mensaje)
            backStackEntry
                ?.savedStateHandle
                ?.remove<String>("mensaje")
        }
    }

    var mostrarDialogo by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color.Black,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Detalle Estudiante",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(padding)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Estudiante",
                modifier = Modifier.size(60.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "${estudiante.nombres} ${estudiante.apellidos}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Carnet: ${estudiante.carnet}", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Grado: ${estudiante.grado}", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Sección: ${estudiante.seccion}", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = if (estudiante.activo) "Estado: Activo" else "Estado: Inactivo",
                color = if (estudiante.activo) Color.Green else Color.Red,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { onEditar(estudiante.id) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Editar")
                }

                Button(
                    onClick = { mostrarDialogo = true },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Eliminar")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = onRegresar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Regresar", color = Color.White)
            }

            if (mostrarDialogo) {
                AlertDialog(
                    onDismissRequest = { mostrarDialogo = false },
                    title = {
                        Text("Confirmación")
                    },
                    text = {
                        Text("¿Estás seguro de eliminar a \"${estudiante.nombres} ${estudiante.apellidos}\"?")
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                mostrarDialogo = false
                                onEliminar(estudiante)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                        ) {
                            Text("Eliminar")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { mostrarDialogo = false }
                        ) {
                            Text("Cancelar")
                        }
                    }
                )
            }
        }
    }
}
