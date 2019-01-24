package ru.madbrains.databindingsample.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import ru.madbrains.databindingsample.data.db.model.ProductLocal

@Dao
interface ProductDao {
    @Query("DELETE FROM products")
    fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<ProductLocal>)

    @Query("SELECT * FROM products WHERE id = :id")
    fun getProductById(id: Int): Flowable<ProductLocal>

    @Query("SELECT * FROM products")
    fun getProducts(): Flowable<List<ProductLocal>>
}