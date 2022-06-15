package io.schiar.proutein.view

import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.BindingAdapter
import io.schiar.proutein.R

object BindingAdapters {
    @BindingAdapter(value=["values"])
    @JvmStatic
    fun setValues(layout: LinearLayoutCompat, values: List<Pair<String, String>>?) {
        values ?: return
        layout.removeAllViews()
        values.forEach {
            val textView = LayoutInflater.from(layout.context).inflate(
                R.layout.unity_view,
                layout,
                false
            ) as TextView
            textView.text = "${it.first}${it.second}"
            layout.addView(textView)
        }
    }
}