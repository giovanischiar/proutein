package io.schiar.proutein.view.viewdata

data class FoodViewData(
    val name: String,
    val serving: List<String>,
    val energy: List<String>,
    val protein: String
)