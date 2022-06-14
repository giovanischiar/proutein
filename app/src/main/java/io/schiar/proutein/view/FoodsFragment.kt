package io.schiar.proutein.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import io.schiar.proutein.R
import io.schiar.proutein.databinding.FoodsFragmentBinding

class FoodsFragment : Fragment() {

    companion object {
        fun newInstance() = FoodsFragment()
    }

    private lateinit var viewModel: FoodsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[FoodsViewModel::class.java]
        val binding: FoodsFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.foods_fragment, container,
            false
        )
        binding.viewModel = viewModel
        return binding.root
    }

}