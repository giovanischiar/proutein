package io.schiar.proutein.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.schiar.proutein.R
import io.schiar.proutein.databinding.FoodsFragmentBinding
import io.schiar.proutein.viewmodel.FoodsViewModel

class FoodsFragment : Fragment(), SelectedFoodListener {

    private lateinit var viewModel: FoodsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[FoodsViewModel::class.java]
        val binding = FoodsFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FoodsFragment
            viewModel = this@FoodsFragment.viewModel
            executePendingBindings()
        }
        viewModel.apply {
            fetch()
            foods.observe(viewLifecycleOwner) {
                binding.adapter = FoodListAdapter(it, this@FoodsFragment)
            }
        }
        return binding.root
    }

    override fun onSelectFood(index: Int) {
        viewModel.foodAt(index)
        val navId = R.id.action_foodsFragment_to_foodFragment
        findNavController().navigate(navId)
    }
}