package bjfu.it.liuchangxin.starbuzz.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository

class CartViewModelFactory(private val commodityRepository: CommodityRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CartViewModel(commodityRepository) as T
    }
}