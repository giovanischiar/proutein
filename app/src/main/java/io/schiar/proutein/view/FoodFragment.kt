package io.schiar.proutein.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.schiar.proutein.databinding.FoodFragmentBinding
import io.schiar.proutein.viewmodel.FoodsViewModel

class FoodFragment : Fragment() {

    private lateinit var viewModel: FoodsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[FoodsViewModel::class.java]
        val binding = FoodFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FoodFragment
            executePendingBindings()
        }
        viewModel.food.observe(viewLifecycleOwner) {
            binding.food = it
            (activity as AppCompatActivity).supportActionBar?.title = it.name
        }
        return binding.root
    }
}