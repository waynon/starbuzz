package bjfu.it.liuchangxin.starbuzz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import bjfu.it.liuchangxin.starbuzz.adapters.HomeBannerAdapter
import bjfu.it.liuchangxin.starbuzz.adapters.HomeCommodityAdapter
import bjfu.it.liuchangxin.starbuzz.databinding.FragmentHomeBinding
import bjfu.it.liuchangxin.starbuzz.utilities.InjectorUtils
import bjfu.it.liuchangxin.starbuzz.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels {
        InjectorUtils.provideHomeViewModelFactory(
            requireContext()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val bannerAdapter = HomeBannerAdapter()
        val favoriteAdapter = HomeCommodityAdapter()
        val trendingAdapter = HomeCommodityAdapter()
        val editorsChoiceAdapter = HomeCommodityAdapter()
        val digitalElectronicsAdapter = HomeCommodityAdapter()
        binding.apply {
            banner.setAdapter(bannerAdapter)
            favorite.adapter = favoriteAdapter
            trending.adapter = trendingAdapter
            editorsChoice.adapter = editorsChoiceAdapter
            digitalElectronics.adapter = digitalElectronicsAdapter
            setSettingsClickListener {
                val intent = Intent(requireActivity(), SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        viewModel.bannerCommodities.observe(viewLifecycleOwner) {
            bannerAdapter.submitList(it.shuffled())
        }
        viewModel.favoriteCommodities.observe(viewLifecycleOwner) {
            binding.hasFavorite = !it.isNullOrEmpty()
            favoriteAdapter.submitList(it)
        }
        viewModel.trendingCommodities.observe(viewLifecycleOwner) {
            trendingAdapter.submitList(it.shuffled())
        }
        viewModel.editorsChoiceCommodities.observe(viewLifecycleOwner) {
            editorsChoiceAdapter.submitList(it.shuffled())
        }
        viewModel.digitalElectronics.observe(viewLifecycleOwner) {
            digitalElectronicsAdapter.submitList(it.shuffled())
        }
        return binding.root
    }
}
