package bjfu.it.liuchangxin.starbuzz.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import bjfu.it.liuchangxin.starbuzz.CategoryListFragment
import bjfu.it.liuchangxin.starbuzz.utilities.PAGE_TYPE_DRINK
import bjfu.it.liuchangxin.starbuzz.utilities.PAGE_TYPE_FOOD
import bjfu.it.liuchangxin.starbuzz.utilities.PAGE_TYPE_STORE

const val DRINK_PAGE_INDEX = 0
const val FOOD_PAGE_INDEX = 1
const val STORE_PAGE_INDEX = 2

class ClassPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val tabFragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        DRINK_PAGE_INDEX to {
            CategoryListFragment.newInstance(PAGE_TYPE_DRINK)
        },
        FOOD_PAGE_INDEX to {
            CategoryListFragment.newInstance(PAGE_TYPE_FOOD)
        },
        STORE_PAGE_INDEX to {
            CategoryListFragment.newInstance(PAGE_TYPE_STORE)
        }
    )

    override fun getItemCount() = tabFragmentsCreator.size

    override fun createFragment(position: Int) =
        tabFragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
}