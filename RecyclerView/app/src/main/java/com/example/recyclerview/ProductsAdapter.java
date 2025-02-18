package com.example.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>{

    private ArrayList<String> products;

    public ProductsAdapter(ArrayList<String> products){
        this.products = products;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView productTxtView;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productTxtView = (TextView) itemView;
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView txtView = new TextView(parent.getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        txtView.setLayoutParams(layoutParams);
        txtView.setPadding(20,20,20,20);
        txtView.setTextSize(20.0F);

        return new ProductViewHolder(txtView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productTxtView.setText(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}