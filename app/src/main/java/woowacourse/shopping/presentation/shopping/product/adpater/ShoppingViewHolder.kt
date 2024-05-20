package woowacourse.shopping.presentation.shopping.product.adpater

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import woowacourse.shopping.databinding.ItemPlusProductBinding
import woowacourse.shopping.databinding.ItemProductBinding
import woowacourse.shopping.presentation.shopping.product.ShoppingUiModel

sealed class ShoppingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    class ProductViewHolder(
        private val binding: ItemProductBinding,
        private val onClickItem: (id: Long) -> Unit,
    ) : ShoppingViewHolder(binding.root) {
        fun bind(product: ShoppingUiModel.Product) {
            binding.product = product
            binding.root.setOnClickListener { onClickItem(product.id) }
        }
    }

    class PlusViewHolder(
        private val binding: ItemPlusProductBinding,
        private val onPlusItem: () -> Unit,
    ) : ShoppingViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener { onPlusItem() }
        }
    }
}
