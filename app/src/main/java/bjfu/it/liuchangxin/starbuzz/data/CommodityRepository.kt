package bjfu.it.liuchangxin.starbuzz.data

class CommodityRepository private constructor(
    private val commodityDao: CommodityDao
) {
    fun getCommoditiesByCategory(category: Category) =
        commodityDao.getCommoditiesByCategory(category)

    fun getCommoditiesById(id: Int) = commodityDao.getCommodityById(id)

    fun getCommodities() = commodityDao.getCommodities()

    suspend fun reverseFavoriteStatusById(id: Int) = commodityDao.reverseFavoriteStatusById(id)

    suspend fun updateQuantityById(id: Int, quantity: Int) =
        commodityDao.updateQuantityById(id, quantity)

    fun getCommoditiesInCart() = commodityDao.getCommoditiesInCart()

    fun getFavoriteCommodities() = commodityDao.getFavoriteCommodities()

    companion object {
        @Volatile
        private var instance: CommodityRepository? = null
        fun getInstance(commodityDao: CommodityDao) = instance ?: synchronized(this) {
            instance ?: CommodityRepository(commodityDao).also { instance = it }
        }
    }
}