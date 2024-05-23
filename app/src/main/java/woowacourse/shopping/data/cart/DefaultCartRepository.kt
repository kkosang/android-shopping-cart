package woowacourse.shopping.data.cart

import android.content.Context
import woowacourse.shopping.data.shopping.DummyShoppingDataSource
import woowacourse.shopping.data.shopping.ShoppingDataSource
import woowacourse.shopping.domain.CartProduct

class DefaultCartRepository(
    private val context: Context,
    private val cartDataSource: CartDataSource = DummyCartDataSource(context),
    private val shoppingDataSource: ShoppingDataSource = DummyShoppingDataSource,
) : CartRepository {
    override fun cartProducts(currentPage: Int): List<CartProduct> {
        return cartDataSource.loadCartProducts(currentPage)
    }

    override fun addCartProduct(productId: Long, count: Int): Long? {
        val product = shoppingDataSource.productById(productId) ?: return null
        return cartDataSource.addCartProduct(product, count)
    }

    override fun deleteCartProduct(productId: Long): Long? {
        val product = shoppingDataSource.productById(productId) ?: return null
        return cartDataSource.deleteCartProduct(product)
    }

    override fun canLoadMoreCartProducts(currentPage: Int): Boolean {
        return cartDataSource.canLoadMoreCartProducts(currentPage)
    }
}
