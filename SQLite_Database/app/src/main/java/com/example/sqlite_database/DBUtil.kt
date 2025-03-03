package com.example.sqlite_database

import android.content.ContentValues
import android.content.Context
import android.util.Log

class DBUtil(context : Context) {

    var db = DBHelper(context,
        "db_products1",
        null,
        1).writableDatabase

    fun insertProduct(id1 : Int, title : String, price : Int) : Boolean{
        val values = ContentValues()
        values.put("id",id1)
        values.put("title",title)
        values.put("price",price)
        val row = db.insert("Product",null,values)
        return row.toInt() != -1
    }

    fun deleteProduct(id1 : Int){
        val count = db.delete("Product","id = ?", arrayOf(id1.toString()))
        Log.e("tag", "count -- $count")
    }

    fun updateProduct(id1 : Int, title: String, price: Int) : Int{
        val values = ContentValues()
        values.put("id", id1)
        values.put("title", title)
        values.put("price", price)
        val count = db.update("Product",values,"id = ?", arrayOf(id1.toString()))

        Log.e("tag", "$count")
        return count
    }

    fun getAllProducts() : ArrayList<Product>{
        val products = ArrayList<Product>()

        val cursor = db.query("Product",null,null,null,null,null,"id desc")

        while (cursor.moveToNext()) {
//            cursor.getColumnName(0)
//            cursor.getColumnName(1)
//            cursor.getColumnName(2)

            val id = cursor.getInt(0)
            val title = cursor.getString(1)
            val price = cursor.getInt(2)

            products.add(Product(id,title,price))
        }

        cursor.close()
        return products
    }
}