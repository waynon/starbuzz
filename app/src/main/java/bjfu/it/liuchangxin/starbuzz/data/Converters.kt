package bjfu.it.liuchangxin.starbuzz.data

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun categoryToString(category: Category): String {
        return category.name
    }

    @TypeConverter
    fun stringToCategory(string: String): Category {
        return Category.valueOf(string)
    }
}