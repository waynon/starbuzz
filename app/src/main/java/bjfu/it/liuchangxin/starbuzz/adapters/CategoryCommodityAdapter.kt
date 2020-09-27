package bjfu.it.liuchangxin.starbuzz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bjfu.it.liuchangxin.starbuzz.CategoryFragmentDirections
import bjfu.it.liuchangxin.starbuzz.data.Commodity
import bjfu.it.liuchangxin.starbuzz.databinding.ListItemCategoryBinding

class CategoryCommodityAdapter :
    ListAdapter<Commodity, CategoryCommodityAdapter.CommodityViewHolder>(CommodityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CommodityViewHolder(
            ListItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CommodityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CommodityViewHolder(private val binding: ListItemCategoryBinding) :
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
                CategoryFragmentDirections.actionCategoryFragmentToCommodityDetailFragment(commodity.id)
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