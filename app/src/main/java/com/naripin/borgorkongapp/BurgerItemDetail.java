package com.naripin.borgorkongapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BurgerItemDetail extends AppCompatActivity {

    private TextView detailNameTextView;
    private TextView detailCostTextView;
    private TextView detailDescriptionTextView;
    private ImageView imageView;
    private EditText burgerAmountEditText;
    private Button buttonAdd;
    private Button buttonPurchase;
    private Button buttonMinus;
    private int counter = 0;
    private int[] burgerOrder = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_item_detail);

        // Get the intent that was used to travel to this activity
        Intent intent = getIntent();

        // Get the extra identified by "burgerID" that was put into the intent at the origin.
        final int burgerID = intent.getIntExtra("BurgerID", 0);

        // Getting the burgerItem data by its specified ID
        final BurgerItem burgerItem = BurgerDatabase.getBurgerItemById(burgerID);

        // Naming the views
        detailNameTextView = findViewById(R.id.burgerDetailName);
        detailCostTextView = findViewById(R.id.burgerDetailCost);
        detailDescriptionTextView = findViewById(R.id.burgerDetailDescription);
        imageView = findViewById(R.id.burgerDetailImage);
        burgerAmountEditText = findViewById(R.id.burgerAmount);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPurchase = findViewById(R.id.buttonPurchase);

        // Set the views to show the data of our object
        detailNameTextView.setText(burgerItem.getName());

        // Adding a $ symbol to cost
        StringBuffer priceString = new StringBuffer("$");
        priceString.append(burgerItem.getCost());

        // Displaying the data
        detailCostTextView.setText(priceString);
        detailDescriptionTextView.setText(burgerItem.getDescription());
        imageView.setImageResource(burgerItem.getImageDrawableId());
        burgerAmountEditText.setText(String.valueOf(counter));

        // Button event listeners
        buttonAdd.setOnClickListener(burgerQuantity);
        buttonMinus.setOnClickListener(burgerQuantity);

        // Ordered burger data added to orderArrayList and mentioned to customer
        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = burgerAmountEditText.getText().toString();
                Integer quantity = Integer.parseInt(userInput);

                if(quantity < 1) {
                    Toast.makeText(getApplicationContext(), "Please enter an amount greater than 0", Toast.LENGTH_SHORT).show();
                } else {
                    burgerOrder[0] = burgerID;
                    burgerOrder[1] = quantity;
                    MainActivity.orderArrayList.add(burgerOrder);
                }

                if (burgerOrder[1] == 1) {
                    Toast.makeText(getApplicationContext(), burgerOrder[1] + " " +
                            burgerItem.getName() + " has been added", Toast.LENGTH_LONG).show();
                } else if (burgerOrder[1] > 1){
                    Toast.makeText(getApplicationContext(), burgerOrder[1] + " " +
                            burgerItem.getName() + "s have been added", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    // Button methods depending on which button was clicked
    private View.OnClickListener burgerQuantity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAdd:
                    incrementCounter();
                    break;
                case R.id.buttonMinus:
                    decrementCounter();
                    break;
                default:
                    break;
            }
        }
    };


    public void incrementCounter() {
        counter++;
        burgerAmountEditText.setText(String.valueOf(counter));
    }

    private void decrementCounter() {
        if (counter == 0) {
            Toast.makeText(this, "The quantity is already at 0", Toast.LENGTH_SHORT).show();
            burgerAmountEditText.setText(String.valueOf(counter));
        } else {
            counter--;
            burgerAmountEditText.setText(String.valueOf(counter));
        }
    }
}
