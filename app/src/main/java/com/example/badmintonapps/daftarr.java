package com.example.badmintonapps;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class daftarr extends AppCompatActivity {

    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarr);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity==100)
        {
            Toast.makeText(this, "Tidak Dapat Membeli Lebih Dari 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        display(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity==1)
        {
            Toast.makeText(this, "Tidak Dapat Membeli Kurang Dari 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity-1;
        display(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText namefield=(EditText)findViewById(R.id.name_field);
        String name = namefield.getText().toString();
        //
        CheckBox WhippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=WhippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price=calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage=createOrderSummary(name, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Beli Racket Atas Nama " +name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    /**
     * Calculates the price of the order.
     *
     *
     */
    private int calculatePrice(boolean addWhipCream, boolean addChocolate) {
        int basePrice = 0;

        if (addWhipCream)
        {
            basePrice = basePrice +2500000;
        }

        if (addChocolate)
        {
            basePrice = basePrice +2350000;
        }
        return quantity*basePrice;
    }
    private String createOrderSummary (String name, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage =getString(R.string.order_summary_name,name);
        priceMessage += "\nMembeli Racket Jenis Yonex "+ addWhippedCream;
        priceMessage += "\nMembeli Racket Jenis Li Ning " + addChocolate;
        priceMessage += "\nJumlah Racket : " + quantity;
        priceMessage += "\nHarga Total Rp" + price;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numberOfCoffe) {
        TextView quantityTextView = (TextView) findViewById
                (R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffe);
    }

}
