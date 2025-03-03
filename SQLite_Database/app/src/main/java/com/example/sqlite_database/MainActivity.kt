package com.example.sqlite_database

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val dbUtil= DBUtil(this)

        /* dbUtil.insertProduct(11,"Mixer",1002)
           dbUtil.insertProduct(12,"T-shirt", 342)

           for (i in 13..16){
               dbUtil.insertProduct(i,"Product " + i, i * 100 + 500)
           } */

        Log.e("tag","-----------GetAllProducts----------")
        for (eachProduct in dbUtil.getAllProducts()){
            Log.e("tag","each_product" + eachProduct.title)
        }

        Log.e("tag","-----------Delete A Product----------")

        dbUtil.deleteProduct(13)

        Log.e("tag","-----------GetAllProducts----------")
        for (eachProduct in dbUtil.getAllProducts()){
            Log.e("tag","each_product" + eachProduct.title)
        }

        dbUtil.deleteProduct(11)

        Log.e("tag","-----------GetAllProducts----------")
        for (eachProduct in dbUtil.getAllProducts()){
            Log.e("tag","each_product" + eachProduct.title)
        }

        Log.e("tag","-----------Update A Product----------")
        dbUtil.updateProduct(12,"iPhone",100000)

        Log.e("tag","-----------GetAllProducts----------")
        for (eachProduct in dbUtil.getAllProducts()){
            Log.e("tag","each_product" + eachProduct.title)
        }
    }
}