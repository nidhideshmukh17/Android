package com.example.recyclerviewproduct;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    ImageView productImageView;
    TextView productTitleTxtView, productPriceTxtView;
    ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products1){
        this.products = products1;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.productImageView);
            productTitleTxtView = itemView.findViewById(R.id.productTitleTxtView);
            productPriceTxtView = itemView.findViewById(R.id.productPriceTxtView);

            productImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //way 3
                    Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                    intent.putExtra("product",products.get(getAdapterPosition()));
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view_holder,null);

        productImageView = productView.findViewById(R.id.productImageView);
        productTitleTxtView = productView.findViewById(R.id.productTitleTxtView);
        productPriceTxtView = productView.findViewById(R.id.productPriceTxtView);

//        productImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(parent.getContext(),"Image View Clicked" , Toast.LENGTH_LONG).show();
//            }
//        });
//
//        productTitleTxtView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(parent.getContext(),"Title Text View Clicked", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        productPriceTxtView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(parent.getContext(),"Price Text View Clicked", Toast.LENGTH_LONG).show();
//            }
//        });

        return new ProductViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);       //extract eachProduct from array of product objects

        //get views from holder bu using findViewById
        productImageView = holder.itemView.findViewById(R.id.productImageView);
        productTitleTxtView = holder.itemView.findViewById(R.id.productTitleTxtView);
        productPriceTxtView = holder.itemView.findViewById(R.id.productPriceTxtView);

        //bind eachProduct data with the corresponding views
        productTitleTxtView.setText(product.productTitle);
        productPriceTxtView.setText(product.productPrice + " ");
        productImageView.setImageResource(R.drawable.ic_launcher_background);

        //way 2 - attaching listeners inside onBindViewHolder method
        /*
        productImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(v.getContext(),"ImageViewClicked  " + product.productId, Toast.LENGTH_SHORT).show();
            }
        });

        productTitleTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"TitleTextViewClicked  " + product.productTitle, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                intent.putExtra("product_title",product.productTitle);
                intent.putExtra("product_price", product.productPrice);
                intent.putExtra("product_image", product.imageId);
                intent.putExtra("product_id", product.productId);

                v.getContext().startActivity(intent);
            }
        });

        productPriceTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(v.getContext(),"PriceTextViewClicked  " + product.productPrice, Toast.LENGTH_SHORT).show();
            }
        }); */
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}