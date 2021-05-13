package com.example.funcraft;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funcraft.adapter.DiscountedProductAdapter;
import com.example.funcraft.model.DiscountedProducts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountedRecyclerView;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountedRecyclerView = findViewById(R.id.discountedRecycler);

        discountedProductsList = new ArrayList<>();

        discountedProductsList.add(new DiscountedProducts(1, R.drawable.h));


        setDiscountedRecycler();

    }

    private void setDiscountedRecycler(ArrayList<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountedRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter();
        discountedRecyclerView.setAdapter(discountedProductAdapter);
    }
}