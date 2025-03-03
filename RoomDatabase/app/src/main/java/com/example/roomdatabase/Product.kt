package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey
    var id : Int,

    @ColumnInfo(name = "product_title")
    var title : String,

    var price : Int
)
