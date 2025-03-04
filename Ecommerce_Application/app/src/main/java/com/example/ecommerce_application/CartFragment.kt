package com.example.ecommerce_application

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce_application.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        cartAdapter = CartAdapter(CartManager.cartItems.toList(), ::onQuantityChanged)
        binding.recyclerView.adapter = cartAdapter

        updateTotal()

        return binding.root
    }

    private fun onQuantityChanged(product: Product, quantity: Int) {
        if (quantity == 0) {
            showRemoveConfirmationDialog(product)
        } else {
            CartManager.updateQuantity(product, quantity)
            updateCart()
        }
    }

    private fun showRemoveConfirmationDialog(product: Product) {
        AlertDialog.Builder(requireContext())
            .setTitle("Remove Item")
            .setMessage("Are you sure you want to remove this item from the cart?")
            .setPositiveButton("Yes") { _, _ ->
                CartManager.removeFromCart(product)
                updateCart()
                Toast.makeText(requireContext(), "Item removed", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun updateCart() {
        cartAdapter.updateCartItems(CartManager.cartItems.toList())
        updateTotal()
    }

    private fun updateTotal() {
        binding.totalAmount.text = "Total: ₹${CartManager.getTotalAmount()}"
    }
}
