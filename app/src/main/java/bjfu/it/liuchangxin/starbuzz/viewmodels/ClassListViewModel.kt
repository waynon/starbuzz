package bjfu.it.liuchangxin.starbuzz.viewmodels

import androidx.lifecycle.ViewModel
import bjfu.it.liuchangxin.starbuzz.data.Category
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository

class ClassListViewModel internal constructor(
    commodityRepository: CommodityRepository,
    category: Category
) :
    ViewModel() {
    val commodities = commodityRepository.getCommoditiesByCategory(category)
}