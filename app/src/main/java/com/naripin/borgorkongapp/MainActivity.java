package com.naripin.borgorkongapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button buttonCart;
    public static ArrayList<int[]> orderArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting the recycler view to the layout manager
        recyclerView = findViewById(R.id.rv_main);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Populate the recycler view with the burger data via the adapter
        BurgerRecyclerViewAdapter burgerRecyclerViewAdapter = new BurgerRecyclerViewAdapter();
        burgerRecyclerViewAdapter.setData(BurgerDatabase.getAllBurgers());
        recyclerView.setAdapter(burgerRecyclerViewAdapter);

        // Open total orders activity
        buttonCart = findViewById(R.id.buttonViewOrder);
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrderCart();
            }
        });
    }

    //
    public void openOrderCart() {
        Intent intent = new Intent(this, OrderCart.class);
        startActivity(intent);
    }
}
