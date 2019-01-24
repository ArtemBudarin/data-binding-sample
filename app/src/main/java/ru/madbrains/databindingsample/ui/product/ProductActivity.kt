package ru.madbrains.databindingsample.ui.product

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.madbrains.databindingsample.R
import ru.madbrains.databindingsample.databinding.ActivityProductBinding
import ru.madbrains.databindingsample.model.Product

class ProductActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel

    companion object {
        private const val KEY_PRODUCT_ID = "PRODUCT_ID"
        fun start(context: Context, product: Product) {
            val intent = Intent(context, ProductActivity::class.java).apply {
                putExtra(KEY_PRODUCT_ID, product.id)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        val binding = DataBindingUtil.setContentView<ActivityProductBinding>(this, R.layout.activity_product).apply {
            viewModel = productViewModel
            setLifecycleOwner(this@ProductActivity)
        }

    }

    override fun onStart() {
        super.onStart()
        productViewModel.setProductId(intent.getIntExtra(KEY_PRODUCT_ID, 0))
    }

}
