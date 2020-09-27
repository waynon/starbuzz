package bjfu.it.liuchangxin.starbuzz.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Commodity(
    val category: Category,
    val name: String,
    val price: Double,
    @ColumnInfo(name = "image_source_id")
    val imageSourceId: Int?,
    val description: String?,
    val favorite: Boolean = false,
    val quantity: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

enum class Category { DRINK, FOOD, STORE }