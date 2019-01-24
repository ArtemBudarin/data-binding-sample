package ru.madbrains.databindingsample.ui.products

import android.content.Context
import ru.madbrains.databindingsample.model.Product

interface ProductClickListener {
    fun onClick(context: Context, product: Product)
}