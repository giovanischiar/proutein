package io.schiar.proutein.model.repository

import android.os.Handler
import android.os.Looper
import io.schiar.proutein.BuildConfig
import io.schiar.proutein.model.Food
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class FoodRepository: FoodRepositoryInterface {
    private val url = "https://sheets.googleapis.com/v4/spreadsheets/${BuildConfig.SPREADSHEET_ID}/values/'Página1'!A:D1?&key=${BuildConfig.API_KEY}"

    override fun fetch(callback: (List<Food>) -> Unit) {
        thread {
            val json = try {
                URL(url).readText()
            } catch (e: Exception) {
                return@thread
            }
            val jsonObj = JSONObject(json)
            val map = jsonObj.toMap()
            @Suppress("UNCHECKED_CAST")
            val values = map["values"] as List<List<String>>?
            val foods = values?.subList(1, values.size)?.map {
                Food(
                    it[0],
                    it[1].replace(',', '.').toDouble(),
                    it[3].replace(',', '.').toDouble(),
                    it[2].replace(',', '.').toDouble()
                )
            }

            Handler(Looper.getMainLooper()).post {
                callback(foods ?: listOf())
            }
        }
    }
}
