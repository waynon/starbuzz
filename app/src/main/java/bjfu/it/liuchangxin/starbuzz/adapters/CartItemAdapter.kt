package bjfu.it.liuchangxin.starbuzz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bjfu.it.liuchangxin.starbuzz.CartFragmentDirections
import bjfu.it.liuchangxin.starbuzz.data.Commodity
import bjfu.it.liuchangxin.starbuzz.databinding.ListItemShoppingCartBinding
import bjfu.it.liuchangxin.starbuzz.utilities.InjectorUtils
import bjfu.it.liuchangxin.starbuzz.viewmodels.CartViewModel

class CartItemAdapter : ListAdapter<Commodity, RecyclerView.ViewHolder>(CommodityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CartItemViewHolder(
        ListItemShoppingCartBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
        parent
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CartItemViewHolder).bind(getItem(position))
    }

    class CartItemViewHolder(
        private val binding: ListItemShoppingCartBinding,
        private val parent: View
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            val viewModel = ViewModelProvider(
                parent.context as ViewModelStoreOwner,
                InjectorUtils.provideCartViewModelFactory(parent.context)
            ).get(CartViewModel::class.java)
            binding.apply {
                setItemClickListener {
                    item?.let { commodity ->
                        navigateToCommodity(commodity, it)
                    }
                }
                setMinusClickListener {
                    item?.let { commodity ->
                        viewModel.setCommodityQuantity(commodity.id, commodity.quantity - 1)
                    }
                }
                setAddClickListener {
                    item?.let { commodity ->
                        viewModel.setCommodityQuantity(commodity.id, commodity.quantity + 1)
                    }
                }
                setRemoveClickListener {
                    item?.let { commodity ->
                        viewModel.setCommodityQuantity(commodity.id, 0)
                    }
                }
            }
        }

        private fun navigateToCommodity(commodity: Commodity, view: View) {
            view.findNavController().navigate(
                CartFragmentDirections.actionCartFragmentToCommodityDetailFragment(commodity.id)
            )
        }

        fun bind(commodity: Commodity) {
            binding.apply {
                item = commodity
                executePendingBindings()
            }
        }
    }
}