package com.example.ecommerce_application

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce_application.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private lateinit var productAdapter: ProductAdapter

    private val productList = listOf(
        Product(1, "Smartphone", "High-quality smartphone", 19999.0, R.drawable.smartphone),
        Product(2, "Laptop", "Powerful gaming laptop", 59999.0, R.drawable.laptop),
        Product(3, "Headphones", "Noise-canceling headphones", 2999.0, R.drawable.headphones),
        Product(4, "TV", "Smart, 4K UHD, immersive sound", 39999.0, R.drawable.tv),
        Product(5, "Refrigerator", "Spacious, energy-efficient, fast cooling", 11999.0, R.drawable.refrigerator),
        Product(6, "AC", "Powerful cooling, energy-efficient, silent", 49999.0, R.drawable.ac),
        Product(7, "Washing Machine", "Efficient cleaning, smart features, durable", 7999.0, R.drawable.washing)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)

        productAdapter = ProductAdapter(productList) { product ->
            openProductDetails(product)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = productAdapter

        return binding.root
    }

    private fun openProductDetails(product: Product) {
        val fragment = ProductDetailsFragment.newInstance(product)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
