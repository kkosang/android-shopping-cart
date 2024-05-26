package woowacourse.shopping.data.recent

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import woowacourse.shopping.domain.Product
import woowacourse.shopping.domain.RecentProduct

@Entity(tableName = "recentProduct")
@TypeConverters(RecentProductConverters::class)
data class RecentProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val product: Product,
    val productId: Long = product.id,
    val viewTime: Long,
) {
    fun toDomainModel() = RecentProduct(
        product = product,
        viewTime = viewTime
    )

    companion object {
        fun makeEntity(product: Product, viewTime: Long): RecentProductEntity {
            return RecentProductEntity(product = product, viewTime = viewTime)
        }
    }
}
