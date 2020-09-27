package bjfu.it.liuchangxin.starbuzz.viewmodels

import androidx.lifecycle.ViewModel
import bjfu.it.liuchangxin.starbuzz.data.Category
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository

class HomeViewModel internal constructor(commodityRepository: CommodityRepository) : ViewModel() {
    val bannerCommodities = commodityRepository.getCommodities()
    val favoriteCommodities = commodityRepository.getFavoriteCommodities()
    val editorsChoiceCommodities = commodityRepository.getCommodities()
    val trendingCommodities = commodityRepository.getCommodities()
    val digitalElectronics = commodityRepository.getCommoditiesByCategory(Category.STORE)
}
