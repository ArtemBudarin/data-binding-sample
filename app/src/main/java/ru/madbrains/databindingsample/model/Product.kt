package ru.madbrains.databindingsample.model

typealias ProductId = Int

data class Product(
        val id: ProductId,
        val name: String,
        val description: String,
        val price: Int,
        val stock: Int,
        val categoryId: Int
)