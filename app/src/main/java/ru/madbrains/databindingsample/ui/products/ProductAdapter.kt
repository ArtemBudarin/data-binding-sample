package ru.madbrains.databindingsample.ui.products

import android.arch.lifecycle.LifecycleOwner
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.madbrains.databindingsample.databinding.ItemProductBinding
import ru.madbrains.databindingsample.model.Product

class ProductAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val clickListener: ProductClickListener
) : ListAdapter<Product, ProductViewHolder>(ProductDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding, clickListener, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProductViewHolder(
        private val binding: ItemProductBinding,
        private val clickListener: ProductClickListener,
        private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product) {
        binding.product = product
        binding.clickListener = clickListener
        binding.setLifecycleOwner(lifecycleOwner)
        binding.executePendingBindings()
    }
}

object ProductDiff : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}