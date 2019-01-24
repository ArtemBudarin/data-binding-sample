package ru.madbrains.databindingsample.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "products")
data class ProductLocal(
        @PrimaryKey val id: Int,
        val name: String,
        val description: String,
        val price: Int,
        val stock: Int,
        val categoryId: Int
)