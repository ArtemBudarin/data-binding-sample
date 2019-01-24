package ru.madbrains.databindingsample.domain.interactors

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.madbrains.databindingsample.domain.interfaces.ProductsRepository
import ru.madbrains.databindingsample.model.Product

class ProductsInteractor(private val productsRepository: ProductsRepository) {

    fun getProductById(id: Int): Observable<Product> {
        return productsRepository.getProductById(id)
                .subscribeOn(Schedulers.io())
    }

    fun getProducts(): Observable<List<Product>> {
        return productsRepository.getProducts()
                .subscribeOn(Schedulers.io())
    }

}