package model

import model.Brand
import model.Type

/**
 * Classe que representa o veículo
 */
data class Vehicle(
    val value: Double,
    val brand: Brand,
    val type: Type
)