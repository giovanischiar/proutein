package io.schiar.proutein.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.schiar.proutein.R
import io.schiar.proutein.databinding.FoodAdapterBinding
import io.schiar.proutein.view.viewdata.FoodViewData

class FoodListAdapter(
    private val foods: List<FoodViewData>,
    private val selectedFoodListener: SelectedFoodListener
    ) :
    RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FoodAdapterBinding>(
            inflater,
            R.layout.food_adapter,
            parent,
            false
        )
        return ViewHolder(binding, selectedFoodListener)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        holder.bind(foods[index], index)
    }

    class ViewHolder(
        private val binding: FoodAdapterBinding,
        private val selectedFoodListener: SelectedFoodListener
        ): RecyclerView.ViewHolder(binding.root) {
        fun bind(food: FoodViewData, index: Int) {
            binding.apply {
                this.food = food
                this.index = index
                this.selectedFoodListener = this@ViewHolder.selectedFoodListener
                executePendingBindings()
            }
        }
    }
}