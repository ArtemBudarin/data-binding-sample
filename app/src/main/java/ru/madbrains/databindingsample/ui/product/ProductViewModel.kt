package ru.madbrains.databindingsample.ui.product

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.madbrains.databindingsample.App
import ru.madbrains.databindingsample.data.repository.ProductsRepositoryImpl
import ru.madbrains.databindingsample.domain.interactors.ProductsInteractor
import ru.madbrains.databindingsample.model.Product
import ru.madbrains.databindingsample.model.ProductId
import ru.madbrains.databindingsample.util.setValueIfNew

@Suppress("NestedLambdaShadowedImplicitParameter")
@SuppressLint("CheckResult")
class ProductViewModel : ViewModel(), LifecycleObserver {

    val interactor = ProductsInteractor(ProductsRepositoryImpl(App.database))

    val product = MediatorLiveData<Product>()

    private val productId = MutableLiveData<ProductId>()

    init {
        product.addSource(productId) {
            it?.let { getProduct(it) }
        }
    }

    private fun getProduct(productId: ProductId) {
        interactor.getProductById(productId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let { product.value = it }
                }, {})
    }

    fun setProductId(newProductId: ProductId) {
        productId.setValueIfNew(newProductId)
    }

}