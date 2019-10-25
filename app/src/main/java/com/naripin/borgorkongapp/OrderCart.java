package com.naripin.borgorkongapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class OrderCart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TextView totalCost;
    private double totalAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_cart);

        // Connecting recycler view to a layout manager
        recyclerView = findViewById(R.id.rv_cart);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Attaching adapter for data to be displayed
        OrderRecyclerViewAdapter orderAdapter = new OrderRecyclerViewAdapter();
        orderAdapter.setData(MainActivity.orderArrayList);
        recyclerView.setAdapter(orderAdapter);


        // Calculating the total cost with burger cost and quantity
        totalCost = findViewById(R.id.orderTotal);

        for (int i = 0; i < MainActivity.orderArrayList.size(); i++) {
            int[] burger = MainActivity.orderArrayList.get(i);
            BurgerItem burgerType = BurgerDatabase.getBurgerItemById(burger[0]);
            int quantity = burger[1];
            totalAmount += quantity * burgerType.getCost();

        }

        // Displaying the total order cost
        StringBuffer totalAmountString = new StringBuffer("Total Order Cost is: $");
        totalAmountString.append(totalAmount);

        totalCost.setText(totalAmountString);
    }

}
