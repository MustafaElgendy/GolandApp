package com.example.golandapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    SharedPreferences sharedMainPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // click listener of companies
        CardView companyCard = (CardView) findViewById(R.id.company_card);
        companyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent companyIntent = new Intent(MainMenu.this,CompaniesList.class);
                startActivity(companyIntent);
            }
        });

        // click listener of my cart
        CardView myCart = (CardView) findViewById(R.id.menu_cart_id);
        myCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartIntent = new Intent(MainMenu.this,CartActivities.class);
                startActivity(cartIntent);
            }
        });

        // click listener of About Us
        CardView aboutUs = (CardView) findViewById(R.id.about_us_id);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(MainMenu.this,AboutUsActivity.class);
                startActivity(aboutIntent);
            }
        });

        //Log out .......
        CardView logOut = (CardView) findViewById(R.id.log_out_id);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedMainPreference = getSharedPreferences("user_details",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedMainPreference.edit();
                editor.clear();
                editor.apply();
                Intent logInIntent = new Intent(MainMenu.this,MainActivity.class);
                logInIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(logInIntent);
                finish();
            }
        });


    }
}
