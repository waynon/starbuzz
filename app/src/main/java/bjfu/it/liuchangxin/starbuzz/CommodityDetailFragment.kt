package bjfu.it.liuchangxin.starbuzz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ShareCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import bjfu.it.liuchangxin.starbuzz.data.Commodity
import bjfu.it.liuchangxin.starbuzz.databinding.FragmentCommodityDetailBinding
import bjfu.it.liuchangxin.starbuzz.utilities.InjectorUtils
import bjfu.it.liuchangxin.starbuzz.viewmodels.CommodityDetailViewModel
import com.google.android.material.snackbar.Snackbar

class CommodityDetailFragment : Fragment() {
    private val viewModel: CommodityDetailViewModel by viewModels {
        InjectorUtils.provideCommodityDetailViewModelFactory(requireContext(), args.commodityId)
    }
    private lateinit var toolbar: Toolbar
    private val args: CommodityDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentCommodityDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommodityDetailBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = this@CommodityDetailFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback {
                override fun add(commodity: Commodity?) {
                    commodity?.let {
                        this@CommodityDetailFragment.viewModel.addCommodityToCart()
                        Snackbar.make(root, R.string.commodity_added_to_cart, Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }
            var isToolbarShown = false
            commodityDetailScrollview.setOnScrollChangeListener(
                NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                    val shouldShowToolbar = scrollY > toolbar.height
                    if (isToolbarShown != shouldShowToolbar) {
                        isToolbarShown = shouldShowToolbar
                        appbar.isActivated = shouldShowToolbar
                        toolbarLayout.isTitleEnabled = shouldShowToolbar
                    }
                }
            )
            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }
            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        startActivity(activity?.let {
                            ShareCompat.IntentBuilder.from(it)
                                .setText(this@CommodityDetailFragment.viewModel.commodity.value?.let {
                                    getString(
                                        R.string.share_text_commodity,
                                        it.name
                                    )
                                }).setType("text/plain").createChooserIntent()
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                        })
                        true
                    }
                    R.id.favorite -> {
                        this@CommodityDetailFragment.viewModel.reverseFavoriteStatus()
                        true
                    }
                    else -> true
                }
            }
            this@CommodityDetailFragment.toolbar = toolbar
        }
        viewModel.commodity.observe(viewLifecycleOwner) {
            toolbar.menu.getItem(0).setIcon(
                when (it.favorite) {
                    true -> R.drawable.ic_favorite
                    false -> R.drawable.ic_not_favorite
                }
            )
        }
        return binding.root
    }

    interface Callback {
        fun add(commodity: Commodity?)
    }
}
