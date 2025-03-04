package com.example.ecommerce_application

object CartManager {
    private val cart = mutableMapOf<Product, Int>()

    val cartItems: List<Pair<Product, Int>>
        get() = cart.toList()

    fun addToCart(product: Product, quantity: Int) {
        cart[product] = (cart[product] ?: 0) + quantity
    }

    fun updateQuantity(product: Product, quantity: Int) {
        if (quantity > 0) {
            cart[product] = quantity
        } else {
            cart.remove(product)
        }
    }

    fun removeFromCart(product: Product) {
        cart.remove(product)
    }

    fun getTotalAmount(): Double {
        return cart.entries.sumOf { (product, quantity) -> product.price * quantity }
    }
}
