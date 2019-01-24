package ru.madbrains.databindingsample.ui.products

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.madbrains.databindingsample.App
import ru.madbrains.databindingsample.data.repository.ProductsRepositoryImpl
import ru.madbrains.databindingsample.domain.interactors.ProductsInteractor
import ru.madbrains.databindingsample.model.Product
import ru.madbrains.databindingsample.ui.product.ProductActivity

@SuppressLint("CheckResult")
class ProductsViewModel: ViewModel(), LifecycleObserver, ProductClickListener {

    val interactor = ProductsInteractor(ProductsRepositoryImpl(App.database))
    val products = MutableLiveData<List<Product>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getProducts() {
        interactor.getProducts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    products.value = it
                }, {})
    }

    override fun onClick(context: Context, product: Product) {
        ProductActivity.start(context, product)
    }
}