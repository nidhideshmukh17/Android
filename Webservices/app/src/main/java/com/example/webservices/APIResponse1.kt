package com.example.webservices

data class APIResponse1(
    var carts : ArrayList<Cart>,
    var total : Int,
    var skip : Int,
    var limit : Int
)

data class Cart(
    var id : Int,
    var products : ArrayList<Product>,
    var total:Double,
    var discountedTotal : Double,
    var userId : Int,
    var totalProducts: Int,
    var totalQuantity : Int
)

data class Product(
    var id : Int,
    var title : String,
    var price : Double,
    var quantity : Int,
    var total : Double,
    var discountPercentage : Double,
    var discountedTotal : Double,
    var thumbnail : String
)
