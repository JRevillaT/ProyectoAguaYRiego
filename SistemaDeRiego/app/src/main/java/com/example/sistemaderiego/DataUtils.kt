package com.example.sistemaderiego

// DataUtils.kt

fun getSampleWaterLevels(): List<WaterLevel> {
    return listOf(
        WaterLevel(
            id = "1",
            title = "Sistema de Riego 1",
            description = "Majes",
            hectares = "10",
            soilType = "Arcilloso",
            waterRetentionCapacity = "Alta"
        ),
        WaterLevel(
            id = "2",
            title = "Sistema de Riego 2",
            description = "Tambo",
            hectares = "25",
            soilType = "Arenoso",
            waterRetentionCapacity = "Media"
        ),
        WaterLevel(
            id = "3",
            title = "Sistema de Riego 3",
            description = "Ocoña",
            hectares = "5",
            soilType = "Franco",
            waterRetentionCapacity = "Baja"
        )
        // Puedes agregar más datos según sea necesario
    )
}
