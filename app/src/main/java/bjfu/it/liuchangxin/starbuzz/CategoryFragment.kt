package bjfu.it.liuchangxin.starbuzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import bjfu.it.liuchangxin.starbuzz.adapters.ClassPagerAdapter
import bjfu.it.liuchangxin.starbuzz.adapters.DRINK_PAGE_INDEX
import bjfu.it.liuchangxin.starbuzz.adapters.FOOD_PAGE_INDEX
import bjfu.it.liuchangxin.starbuzz.adapters.STORE_PAGE_INDEX
import bjfu.it.liuchangxin.starbuzz.databinding.FragmentCategoryBinding
import com.google.android.material.tabs.TabLayoutMediator

class CategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager
        viewPager.adapter = ClassPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, i ->
            tab.setIcon(
                when (i) {
                    DRINK_PAGE_INDEX -> R.drawable.ic_drink
                    FOOD_PAGE_INDEX -> R.drawable.ic_food
                    STORE_PAGE_INDEX -> R.drawable.ic_store
                    else -> throw IndexOutOfBoundsException()
                }
            )
            tab.text = when (i) {
                DRINK_PAGE_INDEX -> getString(R.string.drink_tab_title)
                FOOD_PAGE_INDEX -> getString(R.string.food_tab_title)
                STORE_PAGE_INDEX -> getString(R.string.store_tab_title)
                else -> null
            }
        }.attach()
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
    }
}
