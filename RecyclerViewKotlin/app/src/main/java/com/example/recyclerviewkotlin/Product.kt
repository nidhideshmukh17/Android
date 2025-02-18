package com.example.recyclerviewkotlin

import java.io.Serializable

//model class
class Product(
    var productId : Int,
    var productTitle : String,
    var productImageId : Int,
    var productPrice : Int
) : Serializable{

}