package com.example.funcraft.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funcraft.R;
import com.example.funcraft.model.DiscountedProducts;

import java.util.List;

public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder> {

    Context context;
    List<DiscountedProducts> discountedProductsList;

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items, parent, false);
        return new DiscountedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {
        holder.discountedImageView.setImageResource(Integer.parseInt(discountedProductsList.get(position).getImageurl()));
    }

    @Override
    public int getItemCount() {
        //return discountedProductsList.size();
        return 5;
    }

    public static class DiscountedProductViewHolder extends RecyclerView.ViewHolder{

        ImageView discountedImageView;

        public DiscountedProductViewHolder(@NonNull View itemView) {
            super(itemView);

            discountedImageView = itemView.findViewById(R.id.discountImage);
        }
    }
}
