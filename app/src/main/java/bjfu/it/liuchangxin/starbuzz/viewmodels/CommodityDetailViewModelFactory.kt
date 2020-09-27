package bjfu.it.liuchangxin.starbuzz.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository

class CommodityDetailViewModelFactory(
    private val commodityRepository: CommodityRepository,
    private val id: Int
) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CommodityDetailViewModel(commodityRepository, id) as T
    }
}