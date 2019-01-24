package ru.madbrains.databindingsample.ui.products

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ru.madbrains.databindingsample.R
import ru.madbrains.databindingsample.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    private lateinit var productsViewModel: ProductsViewModel
    private lateinit var adapter: ProductAdapter

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ProductsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productsViewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)

        val binding = DataBindingUtil.setContentView<ActivityProductsBinding>(this, R.layout.activity_products).apply {
            viewModel = productsViewModel
            setLifecycleOwner(this@ProductsActivity)
        }

        adapter = ProductAdapter(this, productsViewModel)

        binding.productsRecyclerView.apply {
            adapter = this@ProductsActivity.adapter
            (layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true
        }

        productsViewModel.products.observe(this, Observer { products ->
            products?.let {
                adapter.submitList(it)
            }
        })

        lifecycle.addObserver(productsViewModel)

    }
}
