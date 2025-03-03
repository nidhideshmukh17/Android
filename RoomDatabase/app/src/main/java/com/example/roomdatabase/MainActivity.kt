package com.example.roomdatabase

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    private val products = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var productDatabase = Room.databaseBuilder(this,
            ProductDatabase::class.java,
            "db_products")
            .allowMainThreadQueries()
            .build()

        var productDao = productDatabase.getProductDao()

        Log.e("tag", "---------insert a product---------")
        productDao.insertProduct(Product(1,"mixer",3455))
        productDao.insertProduct(Product(2,"bottle",231))
        productDao.insertProduct(Product(3,"laptop",56000))
        productDao.insertProduct(Product(4,"charger",500))
        productDao.insertProduct(Product(5,"phone",45634))

        Log.e("tag","---------get All products----------")
        var c = productDao.getAllProducts()
        while (c.moveToNext()){
            var id  = c.getInt(0)
            var title = c.getString(1)
            var price = c.getInt(2)

            products.add(Product(id,title,price))
        }

        for (eachProduct in products){
            Log.e("tag", "eachProductId : " + eachProduct.id+
                    "eachProductTitle :" + eachProduct.title +
                    "eachProductPrice : " + eachProduct.price
            )
        }

        Log.e("tag","---------delete a product----------")
        productDao.deleteProduct(Product(1,"mixer",3455))

        Log.e("tag","---------update a product----------")
        productDao.updateProduct(
            Product(2,"cooker",3452)
        )

        Log.e("tag","---------get All products----------")
        var c1 = productDao.getAllProducts()
        while (c1.moveToNext()){
            var id  = c1.getInt(0)
            var title = c1.getString(1)
            var price = c1.getInt(2)

            products.add(Product(id,title,price))
        }

        for (eachProduct in products){
            Log.e("tag", "eachProductId : " + eachProduct.id+
                    "eachProductTitle :" + eachProduct.title +
                    "eachProductPrice : " + eachProduct.price
            )
        }

    }
}