package io.schiar.proutein.model.repository

import io.schiar.proutein.model.Food

interface FoodRepositoryInterface {
    fun fetch(callback: (List<Food>) -> Unit)
}