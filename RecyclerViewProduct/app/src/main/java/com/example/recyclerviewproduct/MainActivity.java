package com.example.recyclerviewproduct;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView productsRecyclerView;
    private ProductsAdapter productsAdapter;
    private ArrayList<Product> productArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataSet();
        productsRecyclerView = findViewById(R.id.productsRecyclerView);
        productsAdapter = new ProductsAdapter(productArrayList);
        productsRecyclerView.setAdapter(productsAdapter);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));
    }

    private void initDataSet(){
        productArrayList = new ArrayList<Product>();
        for(int i =0;i<10;i++) {
            productArrayList.add(new Product(i + 1,
                    "Product " + i,
                    i * 5 + 10,
                    i
            ));
        }
    }
}