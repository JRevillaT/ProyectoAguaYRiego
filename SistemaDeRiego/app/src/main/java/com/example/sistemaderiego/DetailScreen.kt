package com.example.sistemaderiego

// DetailScreen.kt

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterLevelDetailScreen(waterLevel: WaterLevel, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = waterLevel.title, style = MaterialTheme.typography.h4)
        Text(text = waterLevel.description, style = MaterialTheme.typography.body1)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Hectareas: ${waterLevel.hectares}", style = MaterialTheme.typography.body1)
        Text(text = "Tipo de Suelo: ${waterLevel.soilType}", style = MaterialTheme.typography.body1)
        Text(
            text = "Capacidad de Retención de Agua: ${waterLevel.waterRetentionCapacity}",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Agrega detalles adicionales o componentes según sea necesario

        // Botón de retroceso
        Text(
            text = "Back",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.clickable { onBackClick() }
        )
    }
}
