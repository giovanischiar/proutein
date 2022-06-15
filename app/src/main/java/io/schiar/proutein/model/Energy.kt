package io.schiar.proutein.model

class Energy(value: Double, type: String) {
    var kcal = 0.0
    var kj = 0.0

    init {
        when (type) {
            "kcal" -> {
                this.kcal = value
                this.kj = value * 4.184
            }
            "kj" -> {
                this.kj = value
                this.kcal = value * 0.2390057361
            }
        }
    }
}