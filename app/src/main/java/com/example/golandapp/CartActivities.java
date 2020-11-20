package com.example.golandapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivities extends AppCompatActivity {

    ProductsDBHelper productsDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_activities);


        SharedPreferences preferences = getSharedPreferences("user_details",MODE_PRIVATE);
        final int userID = preferences.getInt("userID",0);

        productsDBHelper = new ProductsDBHelper(this);
        //productsDBHelper.deleteProductsHandler("cartProducts");
        ArrayList<CardContent> cards2 = new ArrayList<CardContent>();
        cards2 = productsDBHelper.loadCartHandler("cartProducts",userID);
        final CartViewAdapter adapter2 = new CartViewAdapter(this,cards2);
        final ListView listView2 = (ListView) findViewById(R.id.cart_list);
        listView2.setAdapter(adapter2);
        final ArrayList<CardContent> finalCards = cards2;
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {



                    final CardContent x = (CardContent) parent.getItemAtPosition(position);
                    int cartProID = x.cartProductID;
                    productsDBHelper.deleteProductsCart("cartProducts", cartProID);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                finalCards.remove(x);
                                adapter2.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });



            }
        });


        Button nextStep = (Button)findViewById(R.id.next_step_id);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = 0;
                String totalProduct = " " ;
                Intent intent = new Intent(CartActivities.this,AddressActivity.class);
                Cursor cursor = productsDBHelper.getDataFromCart(userID);

                    while (cursor.moveToNext()){
                        int price = cursor.getInt(1);
                        int productId = cursor.getInt(2);
                        String product = String.valueOf(productId);
                        totalProduct = totalProduct + "\n" + product ;
                        total += price;
                    }

                Toast.makeText(getApplicationContext(),"Total Price " + total,Toast.LENGTH_LONG).show();
                    intent.putExtra("TotalPrice",total);
                    intent.putExtra("TProductsCart",totalProduct);
                startActivity(intent);
            }
        });

    }
}
