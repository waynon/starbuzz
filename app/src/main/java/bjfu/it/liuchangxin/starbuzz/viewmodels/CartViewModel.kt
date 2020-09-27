package bjfu.it.liuchangxin.starbuzz.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository
import kotlinx.coroutines.launch

class CartViewModel internal constructor(private val commodityRepository: CommodityRepository) :
    ViewModel() {
    val commodities = commodityRepository.getCommoditiesInCart()
    fun setCommodityQuantity(id: Int, quantity: Int) {
        viewModelScope.launch {
            commodityRepository.updateQuantityById(id, quantity)
        }
    }
}