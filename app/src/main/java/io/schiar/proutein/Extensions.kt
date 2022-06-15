import io.schiar.proutein.model.Energy
import io.schiar.proutein.model.Serving
import org.json.JSONArray
import org.json.JSONObject
import java.math.RoundingMode
import java.text.DecimalFormat

fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
    when (val value = this[it])
    {
        is JSONArray ->
        {
            val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
            JSONObject(map).toMap().values.toList()
        }
        is JSONObject -> value.toMap()
        JSONObject.NULL -> null
        else            -> value
    }
}

fun Serving.toViewData(): List<Pair<String, String>> {
    return listOf(
        Pair(this.grams.format(), "g"),
        Pair(this.ounces.format(), "oz")
    )
}

fun Energy.toViewData(): List<Pair<String, String>> {
    return listOf(
        Pair(this.kcal.format(), "kcal"),
        Pair(this.kj.format(), "kj")
    )
}

fun Double.format(unity: String = ""): String {
    val df = DecimalFormat("#.##");
    df.roundingMode = RoundingMode.HALF_EVEN
    return df.format(this).toString() + unity
}