package com.naripin.borgorkongapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BurgerRecyclerViewAdapter extends RecyclerView.Adapter<BurgerRecyclerViewAdapter.BurgerViewHolder> {

    private ArrayList<BurgerItem> burgersToAdapt;

    // Method to give data to the adapter
    public void setData(ArrayList<BurgerItem> burgersToAdapt) {
        this.burgersToAdapt = burgersToAdapt;
    }

    // Create burger views within the recycler view (invoked by the layout manager)
    @NonNull
    @Override
    public BurgerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.burger_item, parent, false);

        BurgerViewHolder burgerViewHolder = new BurgerViewHolder(view);
        return burgerViewHolder;
    }

    // Assigning the burger data on the specified view holder
    @Override
    public void onBindViewHolder(@NonNull BurgerViewHolder holder, int position) {

        final BurgerItem burgerAtPosition = burgersToAdapt.get(position);

        holder.nameTextView.setText(burgerAtPosition.getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, BurgerItemDetail.class);
                intent.putExtra("BurgerID", burgerAtPosition.getBurgerID());
                context.startActivity(intent);
            }
        });

        holder.itemImageView.setImageResource(burgerAtPosition.getImageDrawableId());
    }

    // Returns the total number of items in the data set held by the adapter.
    @Override
    public int getItemCount() {
        return burgersToAdapt.size();
    }

    // ViewHolder elements
    public static class BurgerViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView nameTextView;
        public ImageView itemImageView;

        // Constructor used in onCreateViewHolder
        public BurgerViewHolder(View v) {
            super(v);
            view = v;
            nameTextView = v.findViewById(R.id.burgerName);
            itemImageView = v.findViewById(R.id.burgerImage);
        }
    }
}

