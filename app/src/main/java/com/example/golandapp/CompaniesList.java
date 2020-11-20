package com.example.golandapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CompaniesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_list);

        Button cartB = (Button) findViewById(R.id.cart_company_id);
        cartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartIntent = new Intent(CompaniesList.this,CartActivities.class);
                startActivity(cartIntent);
            }
        });
    }
}
