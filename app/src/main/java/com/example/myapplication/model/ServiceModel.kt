package com.example.myapplication.model

data class ServiceModel(val name: String, val cost: Double)
data class UiState(
    val selectedTab: Int = 0,
    val services: List<ServiceModel> = emptyList(),
    val minusShift: String = "",
    val totalCost: Double = 0.0,
    val currentName: String = "",
    val girls: List<String> = emptyList()
)
