package ru.madbrains.databindingsample.data.mappers

import ru.madbrains.databindingsample.data.db.model.ProductLocal
import ru.madbrains.databindingsample.model.Product

fun mapProductLocalToProduct(productLocal: ProductLocal): Product {
    return with (productLocal) {
        Product(id, name, description, price, stock, categoryId)
    }
}