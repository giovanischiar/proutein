package io.schiar.proutein.model.repository

import io.schiar.proutein.model.Food

class FoodRepository: FoodRepositoryInterface {
    private val foods = listOf(
        Food(
            "Cod Filé",
            113.0,
            90.0,
            20.0
        ),
        Food(
            "Peru Moído",
            112.0,
            120.0,
            26.0
        ),
        Food(
            "Peito de Frango",
            100.0,
            120.0,
            23.1
        ),
        Food(
            "Atum Albacore",
            85.0,
            100.0,
            21.0
        )
    )

    override fun fetch(callback: (List<Food>) -> Unit) {
        callback(foods)
    }
}