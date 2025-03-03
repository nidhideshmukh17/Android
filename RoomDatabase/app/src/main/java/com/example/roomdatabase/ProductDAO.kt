package com.example.roomdatabase

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDAO {
    @Insert
    fun insertProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Query("Select * from Products")
    fun getAllProducts() : Cursor

    @Query("delete from Products where id = :id")
    fun deleteById(id : Int) : Int
}