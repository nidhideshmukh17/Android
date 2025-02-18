package com.example.webservices

import android.util.Log
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class WebThread1 : Thread() {
    private var carts1 :  ArrayList<Cart> = ArrayList<Cart>()
    private var products1 : ArrayList<Product> = ArrayList<Product>()

    override fun run() {
        super.run()

        val url = URL("https://dummyjson.com/carts")
        var httpsURLConnection = url.openConnection() as HttpsURLConnection
        httpsURLConnection.connect()

//        Log.e("tag", httpsURLConnection.url.toString())
//        Log.e("tag", httpsURLConnection.contentType)
//        Log.e("tag",httpsURLConnection.contentEncoding)
//        Log.e("tag", httpsURLConnection.requestMethod)
//        Log.e("tag",httpsURLConnection.responseMessage)

        var inputStream = httpsURLConnection.inputStream

        var buffer = StringBuffer()
        var byteArray = ByteArray(1024 * 1)
        var count = 0

        count = inputStream.read(byteArray)
        while (count != -1){
            buffer.append(String(byteArray,0,count))
            count = inputStream.read(byteArray)
        }

        inputStream.close()

        val responseObject = JSONObject(buffer.toString())

        var carts = responseObject.getJSONArray("carts")

        var total  = responseObject.getInt("total")
        var skip = responseObject.getInt("skip")
        var limit = responseObject.getInt("limit")

        for(i in 0..carts.length() - 1){
            val eachCart = carts.getJSONObject(i)
            val id = eachCart.getInt("id")
            val products = eachCart.getJSONArray("products")
            val total = eachCart.getDouble("total")
            val discountedTotal = eachCart.getDouble("discountedTotal")
            var userId = eachCart.getInt("userId")
            var totalProducts = eachCart.getInt("totalProducts")
            var totalQuantity = eachCart.getInt("totalQuantity")

            for (j in 0..products.length()-1){
                val eachProduct = products.getJSONObject(j)
                val eachProductId = eachProduct.getInt("id")
                val eachProductTitle = eachProduct.getString("title")
                val eachProductPrice = eachProduct.getDouble("price")
                val eachProductTotal = eachProduct.getDouble("total")
                val eachProductQuantity = eachProduct.getInt("quantity")
                val eachProductPercentage = eachProduct.getDouble("discountPercentage")
                val eachProductDiscountedTotal = eachProduct.getDouble("discountedTotal")
                val eachProductImage = eachProduct.getString("thumbnail")

                products1.add(Product(eachProductId,
                    eachProductTitle,
                    eachProductPrice,
                    eachProductQuantity,
                    eachProductTotal,
                    eachProductPercentage,
                    eachProductDiscountedTotal,
                    eachProductImage))

                for (eachPr in products1) {
                    Log.e("tag","${eachPr.id} -- ${eachPr.title} -- ${eachPr.price}")
                }
            }

            carts1.add(Cart(id,
                products1,
                total,
                discountedTotal,
                userId,
                totalProducts,
                totalQuantity))

            for(eachCart in carts1){
                Log.e("tag", "${eachCart.id} -- ${eachCart.totalProducts}")
            }
        }
    }
}