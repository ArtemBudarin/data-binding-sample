package ru.madbrains.databindingsample.domain.interfaces

import io.reactivex.Observable
import ru.madbrains.databindingsample.model.Product

interface ProductsRepository {
    fun getProductById(id: Int): Observable<Product>
    fun getProducts(): Observable<List<Product>>
}