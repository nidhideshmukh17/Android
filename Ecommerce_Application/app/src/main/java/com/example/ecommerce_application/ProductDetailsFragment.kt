package com.example.ecommerce_application

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.ecommerce_application.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var product: Product

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)

        arguments?.let {
            product = it.getParcelable("product")!!

            binding.productTitle.text = product.title
            binding.productPrice.text = "₹${product.price}"
            binding.productDescription.text = product.description
            binding.productImage.setImageResource(product.imageResId)

            binding.addToCartButton.setOnClickListener {
                CartManager.addToCart(product, 1)
            }
        }

        return binding.root
    }

    companion object {
        fun newInstance(product: Product): ProductDetailsFragment {
            return ProductDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("product", product)
                }
            }
        }
    }
}
