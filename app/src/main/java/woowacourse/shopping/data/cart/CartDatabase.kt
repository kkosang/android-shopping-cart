package woowacourse.shopping.data.cart

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartEntity::class], version = 1)
abstract class CartDatabase : RoomDatabase() {
    abstract fun dao(): CarDao

    companion object {
        private var instance: CartDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CartDatabase {
            return instance ?: Room.databaseBuilder(
                context.applicationContext,
                CartDatabase::class.java,
                "cart.db"
            ).build()
        }
    }
}
