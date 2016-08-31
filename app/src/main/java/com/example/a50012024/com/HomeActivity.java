package com.example.a50012024.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import java.text.NumberFormat;

public class HomeActivity extends AppCompatActivity {

    int quantity = 0, costPerItem = 5;
    String OrderSummary="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
    }

    @Override
    public boolean  onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_profile:
                viewProfile(getCurrentFocus());
                return true;
            case R.id.action_profile_options:
                viewAccountSettings(getCurrentFocus());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void viewProfile(View view) {
        Intent i = new Intent(this, DetailsActivity.class);
        startActivity(i);
    }

    private void viewAccountSettings(View view) {
        Intent i = new Intent(this, DetailsActivity.class);
        startActivity(i);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String OrderSummary = createOrderSummary(quantity);
        displayMessage(OrderSummary);
        if (quantity >= 1) {
            OrderSummary = "Your Order Summary" + "\n" + OrderSummary;
        }
        Toast.makeText(HomeActivity.this, OrderSummary, Toast.LENGTH_SHORT).show();
    }

    private String createOrderSummary(int quantity) {
        OrderSummary = "Name : Ajith ";
        OrderSummary = OrderSummary + "\nQuantity :" + quantity;
        OrderSummary = OrderSummary + "\nTotal :" + "$" + calculatePrice(quantity, 5);
        if (quantity < 1) {
            OrderSummary = "You have not selected anything";
        } else if (quantity >= 1) {
            OrderSummary = OrderSummary + "\nThank You !";
        }
        return OrderSummary;
    }

    private int calculatePrice(int quantity, int costPerItem) {

        return quantity * costPerItem;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /*Reset button to clear the price and quantity textviews*/
    public void resetOrder(View view) {
        TextView quantityTextView = (TextView) findViewById((R.id.quantity_text_view));
        quantityTextView.setText("0");
        TextView priceTextView = (TextView) findViewById((R.id.order_summary_text_view));
        priceTextView.setText("$0.0");
        quantity = 0;
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    public void sendEmail(View view) {
        Toast.makeText(HomeActivity.this, "Welcome Toast Messages", Toast.LENGTH_SHORT).show();
        //        Intent i = new Intent(Intent.ACTION_SEND);
//        i.setType("message/rfc822");
//        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
//        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
//        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
//        try {
//            startActivity(Intent.createChooser(i, "Send mail..."));
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(HomeActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
//        }

    }

    public void viewDetails(View view) {
        Intent i = new Intent(this, DetailsActivity.class);
        i.putExtra("MasterOrderDetails",OrderSummary );
        startActivity(i);
    }

    public void onCheckboxClicked(View view){
        boolean isChecked = ((CheckBox)view).isChecked();
        
    }
}