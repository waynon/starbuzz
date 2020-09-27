package bjfu.it.liuchangxin.starbuzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import bjfu.it.liuchangxin.starbuzz.adapters.CartItemAdapter
import bjfu.it.liuchangxin.starbuzz.databinding.FragmentCartBinding
import bjfu.it.liuchangxin.starbuzz.utilities.InjectorUtils
import bjfu.it.liuchangxin.starbuzz.viewmodels.CartViewModel

class CartFragment : Fragment() {
    private val viewModel: CartViewModel by viewModels {
        InjectorUtils.provideCartViewModelFactory(requireContext())
    }
    lateinit var binding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        val adapter = CartItemAdapter()
        binding.cartList.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: CartItemAdapter) {
        viewModel.commodities.observe(viewLifecycleOwner) {
            binding.hasCommodities = !it.isNullOrEmpty()
            adapter.submitList(it)
            var sum = 0.0
            for (e in it)
                sum += e.price * e.quantity
            binding.total = sum
        }
    }
}
