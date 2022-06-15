package io.schiar.proutein.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.schiar.proutein.R
import io.schiar.proutein.databinding.FoodAdapterBinding
import io.schiar.proutein.databinding.FoodsFragmentBinding
import io.schiar.proutein.view.viewdata.FoodViewData

class FoodListAdapter(private val foods: List<FoodViewData>) :
    RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FoodAdapterBinding>(
            inflater,
            R.layout.food_adapter,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foods[position])
    }

    class ViewHolder(private val binding: FoodAdapterBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(food: FoodViewData) {
            binding.apply {
                this.food = food
                executePendingBindings()
            }
        }
    }
}