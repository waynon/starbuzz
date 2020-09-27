package bjfu.it.liuchangxin.starbuzz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import bjfu.it.liuchangxin.starbuzz.utilities.DATABASE_NAME
import bjfu.it.liuchangxin.starbuzz.workers.SeedDatabaseWorker

@Database(
    entities = [Commodity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class StarbuzzDatabase : RoomDatabase() {
    abstract fun commodityDao(): CommodityDao

    companion object {
        @Volatile
        private var instance: StarbuzzDatabase? = null
        fun getInstance(context: Context): StarbuzzDatabase = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(context, StarbuzzDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration().addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        WorkManager.getInstance(context)
                            .enqueue(OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build())
                    }
                }).build().also { instance = it }
        }
    }
}