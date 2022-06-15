package io.schiar.proutein.view.viewdata

data class FoodViewData(
    val name: String,
    val serving: List<Pair<String, String>>,
    val energy: List<Pair<String, String>>,
    val protein: String
)