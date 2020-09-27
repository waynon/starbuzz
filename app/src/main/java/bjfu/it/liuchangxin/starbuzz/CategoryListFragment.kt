package bjfu.it.liuchangxin.starbuzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import bjfu.it.liuchangxin.starbuzz.adapters.CategoryCommodityAdapter
import bjfu.it.liuchangxin.starbuzz.data.Category
import bjfu.it.liuchangxin.starbuzz.databinding.FragmentCategoryListBinding
import bjfu.it.liuchangxin.starbuzz.utilities.InjectorUtils
import bjfu.it.liuchangxin.starbuzz.utilities.PAGE_TYPE
import bjfu.it.liuchangxin.starbuzz.viewmodels.ClassListViewModel

class CategoryListFragment : Fragment() {
    private val viewModel: ClassListViewModel by viewModels {
        InjectorUtils.provideClassListViewModelFactory(
            requireContext(),
            Category.valueOf(requireArguments().getString(PAGE_TYPE)!!)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryListBinding.inflate(inflater, container, false)
        val adapter = CategoryCommodityAdapter()
        binding.classPagerList.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: CategoryCommodityAdapter) {
        viewModel.commodities.observe(viewLifecycleOwner) { commodities ->
            adapter.submitList(commodities)
        }
    }

    companion object {
        fun newInstance(pageType: String) =
            CategoryListFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        PAGE_TYPE,
                        pageType
                    )
                }
            }
    }
}