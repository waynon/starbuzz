package bjfu.it.liuchangxin.starbuzz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bjfu.it.liuchangxin.starbuzz.HomeFragmentDirections
import bjfu.it.liuchangxin.starbuzz.data.Commodity
import bjfu.it.liuchangxin.starbuzz.databinding.ListItemHomeBinding


class HomeCommodityAdapter :
    ListAdapter<Commodity, HomeCommodityAdapter.CommodityViewHolder>(CommodityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CommodityViewHolder(
            ListItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CommodityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CommodityViewHolder(private val binding: ListItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.item?.let { commodity ->
                    navigateToCommodity(commodity, it)
                }
            }
        }

        private fun navigateToCommodity(commodity: Commodity, view: View) {
            view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToCommodityDetailFragment(commodity.id)
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

internal class CommodityDiffCallback : DiffUtil.ItemCallback<Commodity>() {
    override fun areItemsTheSame(oldItem: Commodity, newItem: Commodity) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Commodity, newItem: Commodity) = oldItem == newItem
}