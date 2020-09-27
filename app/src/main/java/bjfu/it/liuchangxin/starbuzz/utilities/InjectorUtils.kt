package bjfu.it.liuchangxin.starbuzz.utilities

import android.content.Context
import bjfu.it.liuchangxin.starbuzz.data.Category
import bjfu.it.liuchangxin.starbuzz.data.CommodityRepository
import bjfu.it.liuchangxin.starbuzz.data.StarbuzzDatabase
import bjfu.it.liuchangxin.starbuzz.viewmodels.CartViewModelFactory
import bjfu.it.liuchangxin.starbuzz.viewmodels.ClassListViewModelFactory
import bjfu.it.liuchangxin.starbuzz.viewmodels.CommodityDetailViewModelFactory
import bjfu.it.liuchangxin.starbuzz.viewmodels.HomeViewModelFactory

object InjectorUtils {
    private fun getCommodityRepository(context: Context) = CommodityRepository.getInstance(
        StarbuzzDatabase.getInstance(context.applicationContext).commodityDao()
    )

    fun provideHomeViewModelFactory(context: Context) =
        HomeViewModelFactory(getCommodityRepository(context))

    fun provideClassListViewModelFactory(context: Context, category: Category) =
        ClassListViewModelFactory(
            getCommodityRepository(context), category
        )

    fun provideCommodityDetailViewModelFactory(context: Context, id: Int) =
        CommodityDetailViewModelFactory(
            getCommodityRepository(context), id
        )

    fun provideCartViewModelFactory(context: Context) = CartViewModelFactory(
        getCommodityRepository(context)
    )
}