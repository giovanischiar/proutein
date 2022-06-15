package io.schiar.proutein.model

class Serving(value: Double, type: String) {
    var grams = 0.0
    var ounces = 0.0

    init {
        when (type) {
            "g" -> {
                this.grams = value
                this.ounces = value / 28.34952
            }
            "oz" -> {
                this.ounces = value
                this.grams = value * 28.34952
            }
        }
    }
}
