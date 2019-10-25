package com.naripin.borgorkongapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<OrderRecyclerViewAdapter.OrderViewHolder> {

    private ArrayList<int[]> orderList;


    // Method to give data to the adapter
    public void setData(ArrayList<int[]> orderList) {
        this.orderList = orderList;
    }

    // Create order views within the recycler view (invoked by the layout manager)
    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);
        OrderViewHolder OrderViewHolder = new OrderViewHolder(view);

        return OrderViewHolder;

    }

    // Assigning the order data on the specified view holder
    @Override
    public void onBindViewHolder(final OrderViewHolder holder, final int position) {
        int[] burgerOrder = orderList.get(position);
        BurgerItem burger = BurgerDatabase.getBurgerItemById(burgerOrder[0]);
        int quantity = burgerOrder[1];

        holder.orderBurgerName.setText(burger.getName());

        StringBuffer costString = new StringBuffer("Per price $");
        costString.append(burger.getCost());
        holder.cost.setText(costString);

        StringBuffer quantityString = new StringBuffer("Quantity: ");
        quantityString.append(quantity);
        holder.orderQuantity.setText(quantityString);

        StringBuffer subTotalString = new StringBuffer("Subtotal: $");
        subTotalString.append(Math.round((burger.getCost() * quantity) * 100.0) / 100.0);
        holder.subTotal.setText(subTotalString);

        holder.itemImageView.setImageResource(burger.getImageDrawableId());
    }

    // Returns the total number of items in the data set held by the adapter.
    public int getItemCount() {
        return orderList.size();

    }

    // ViewHolder elements
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView orderBurgerName;
        public TextView cost;
        public ImageView itemImageView;
        public TextView orderQuantity;
        public TextView subTotal;
        public TextView orderTotal;


        public OrderViewHolder(View v) {
            super(v);
            view = v;
            orderBurgerName = v.findViewById(R.id.orderBurgerName);
            cost = v.findViewById(R.id.orderBurgerCost);
            itemImageView = v.findViewById(R.id.orderImage);
            orderQuantity = v.findViewById(R.id.orderQuantity);
            subTotal = v.findViewById(R.id.orderSubtotal);
            orderTotal = v.findViewById(R.id.orderTotal);
        }
    }
}
