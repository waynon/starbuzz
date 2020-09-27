package bjfu.it.liuchangxin.starbuzz.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bjfu.it.liuchangxin.starbuzz.data.Category
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository

class ClassListViewModelFactory(
    private val commodityRepository: CommodityRepository,
    private val category: Category
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ClassListViewModel(commodityRepository, category) as T
    }
}