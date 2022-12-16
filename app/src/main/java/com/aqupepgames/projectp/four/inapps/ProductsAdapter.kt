package com.aqupepgames.projectp.four.inapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.TableRowProductBinding
import com.qonversion.android.sdk.dto.offerings.QOffering
import com.qonversion.android.sdk.dto.offerings.QOfferings
import com.qonversion.android.sdk.dto.products.QProduct

class ProductsAdapter(
    private val products: List<QProduct>,
    private val onItemClicked: (QProduct) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.RowViewHolder>() {

    private lateinit var binding: TableRowProductBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        binding = TableRowProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RowViewHolder(binding.root) { index ->
            onItemClicked(products[index])
        }
    }
    override fun onBindViewHolder(holder: RowViewHolder, position: Int) =
        holder.bind(products[position])

    override fun getItemCount() = products.size

    inner class RowViewHolder(itemView: View, onItemClicked: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        fun bind(product: QProduct) = with(itemView) {
            binding.txtName.setImageResource(R.drawable.four)
            binding.txtDescription.text = product.skuDetail?.description
            binding.txtPrice.text = product.skuDetail?.price
        }
    }
}