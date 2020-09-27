package bjfu.it.liuchangxin.starbuzz.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface CommodityDao {
    @Query(
        "SELECT * FROM commodity WHERE category=:category"
    )
    fun getCommoditiesByCategory(category: Category): LiveData<List<Commodity>>

    @Query(
        "SELECT * FROM commodity WHERE commodity.id=:id"
    )
    fun getCommodityById(id: Int): LiveData<Commodity>

    @Query(
        "SELECT * FROM commodity WHERE name=:name"
    )
    fun getCommoditiesByName(name: String): LiveData<Commodity>

    @Query("SELECT * FROM commodity")
    fun getCommodities(): LiveData<List<Commodity>>

    @Insert
    suspend fun insertAll(commodities: List<Commodity>)

    @Query("SELECT favorite FROM commodity WHERE id=:id")
    suspend fun getFavoriteById(id: Int): Boolean

    @Query("UPDATE commodity SET favorite=:favorite WHERE id=:id")
    suspend fun updateFavoriteById(id: Int, favorite: Boolean)

    @Transaction
    suspend fun reverseFavoriteStatusById(id: Int) {
        updateFavoriteById(id, !getFavoriteById(id))
    }

    @Query("UPDATE commodity SET quantity=:quantity WHERE id=:id")
    suspend fun updateQuantityById(id: Int, quantity: Int)

    @Query("SELECT * FROM commodity WHERE quantity>0")
    fun getCommoditiesInCart(): LiveData<List<Commodity>>

    @Query("SELECT * FROM commodity WHERE favorite=1")
    fun getFavoriteCommodities(): LiveData<List<Commodity>>
}