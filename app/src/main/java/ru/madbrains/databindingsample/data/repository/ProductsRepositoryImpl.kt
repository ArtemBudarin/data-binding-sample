package ru.madbrains.databindingsample.data.repository

import io.reactivex.Observable
import ru.madbrains.databindingsample.data.db.AppDatabase
import ru.madbrains.databindingsample.domain.interfaces.ProductsRepository
import ru.madbrains.databindingsample.data.mappers.mapProductLocalToProduct
import ru.madbrains.databindingsample.model.Product

class ProductsRepositoryImpl(
        private val db: AppDatabase
) : ProductsRepository {

    override fun getProductById(id: Int): Observable<Product> {
        return db.productDao().getProductById(id)
                .toObservable()
                .map { mapProductLocalToProduct(it) }
    }

    override fun getProducts(): Observable<List<Product>> {
        return db.productDao().getProducts()
                .toObservable()
                .map { it -> it.map { mapProductLocalToProduct(it) } }
    }
}