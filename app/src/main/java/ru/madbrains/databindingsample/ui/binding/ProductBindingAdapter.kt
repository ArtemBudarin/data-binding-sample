package ru.madbrains.databindingsample.ui.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import ru.madbrains.databindingsample.R

@BindingAdapter("imageId")
fun imageId(imageView: ImageView, imageId: Int) {
    val imageResource = when (imageId) {
        1 -> R.drawable.ic_book
        2 -> R.drawable.ic_feed
        3 -> R.drawable.ic_electronic
        else -> R.drawable.ic_unknown
    }
    imageView.setImageResource(imageResource)
}

@BindingAdapter("productStock")
fun productStock(textView: TextView, value: Int) {
    val stock = if (value > 0) {
        String.format(textView.context.getString(R.string.item_product_stock), value)
    } else {
        textView.context.getString(R.string.item_product_stock_out)
    }

    textView.text = stock
}