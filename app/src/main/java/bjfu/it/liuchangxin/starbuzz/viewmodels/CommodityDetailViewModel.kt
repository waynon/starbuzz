package bjfu.it.liuchangxin.starbuzz.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository
import kotlinx.coroutines.launch

class CommodityDetailViewModel internal constructor(
    private val commodityRepository: CommodityRepository,
    private val id: Int
) :
    ViewModel() {
    val commodity = commodityRepository.getCommoditiesById(id)
    fun addCommodityToCart() {
        viewModelScope.launch {
            commodityRepository.updateQuantityById(id, commodity.value!!.quantity + 1)
        }
    }

    fun reverseFavoriteStatus() {
        viewModelScope.launch {
            commodityRepository.reverseFavoriteStatusById(id)
        }
    }
}