package com.example.sistemaderiego
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterLevelApp()
        }
    }
}

@Composable
fun WaterLevelApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "waterLevelList"
    ) {
        composable("waterLevelList") {
            WaterLevelListScreen(navController)
        }
        composable(
            "waterLevelDetail/{waterLevelId}",
            arguments = listOf(navArgument("waterLevelId") { type = NavType.StringType })
        ) { backStackEntry ->
            val waterLevelId = backStackEntry.arguments?.getString("waterLevelId")
            waterLevelId?.let {
                val waterLevel = getWaterLevelById(it) // Implementa esta función según tus necesidades
                if (waterLevel != null) {
                    WaterLevelDetailScreen(waterLevel = waterLevel, onBackClick = {
                        navController.popBackStack()
                    })
                }
            }
        }
    }
}

@Composable
fun WaterLevelListScreen(navController: NavHostController) {
    val viewModel: WaterLevelViewModel = viewModel()
    LaunchedEffect(true) {
        viewModel.initializeWaterLevels()
    }

    val waterLevels by viewModel.waterLevels.collectAsState()

    Column {
        TopAppBar(
            title = { Text("Water Levels") },
            //backgroundColor = MaterialTheme.colorScheme.primary
        )

        WaterLevelList(waterLevels) { waterLevelId ->
            navController.navigate("waterLevelDetail/$waterLevelId")
        }
    }
}

@Composable
fun WaterLevelList(waterLevels: List<WaterLevel>, onItemClick: (String) -> Unit) {
    LazyColumn {
        items(waterLevels) { waterLevel ->
            WaterLevelListItem(waterLevel, onItemClick)
        }
    }
}

@Composable
fun WaterLevelListItem(waterLevel: WaterLevel, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(waterLevel.id) }
            .padding(16.dp)
    ) {
        Text(text = waterLevel.title, style = MaterialTheme.typography.h6)
        Text(text = waterLevel.description, style = MaterialTheme.typography.body2)
    }
}

fun getWaterLevelById(id: String): WaterLevel? {
    // Implementa la lógica para obtener el WaterLevel correspondiente según el ID
    return getSampleWaterLevels().find { it.id == id }
}
