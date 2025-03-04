package com.example.ecommerce_application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce_application.databinding.ItemCartBinding

class CartAdapter(
    private var cartItems: List<Pair<Product, Int>>,
    private val onQuantityChanged: (Product, Int) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val (product, quantity) = cartItems[position]

        holder.binding.productTitle.text = product.title
        holder.binding.productPrice.text = "₹${product.price}"
        holder.binding.productQuantity.text = quantity.toString()
        holder.binding.productImage.setImageResource(product.imageResId)

        holder.binding.incrementButton.setOnClickListener {
            onQuantityChanged(product, quantity + 1)
        }

        holder.binding.decrementButton.setOnClickListener {
            onQuantityChanged(product, quantity - 1)
        }

        holder.binding.removeButton.setOnClickListener {
            onQuantityChanged(product, 0)
        }
    }

    override fun getItemCount(): Int = cartItems.size

    fun updateCartItems(newCartItems: List<Pair<Product, Int>>) {
        cartItems = newCartItems
        notifyDataSetChanged()
    }
}
