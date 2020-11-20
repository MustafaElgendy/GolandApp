package com.example.golandapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddressActivity extends AppCompatActivity {
    EditText name;
    EditText address;
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        name = (EditText)findViewById(R.id.name_text_id);


         address = (EditText)findViewById(R.id.address_text_id);


        phone = (EditText)findViewById(R.id.phone_text_id);
        final int price;
        Bundle mBundle = getIntent().getExtras();

        price = mBundle.getInt("TotalPrice");
        final String Products = mBundle.getString("TProductsCart");


        Button submit = (Button)findViewById(R.id.send_request_id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String phoneNumber = phone.getText().toString();
                String userAddress = address.getText().toString();
                String order = "NAME : " + userName + "\n User Address : " + userAddress + "\n User Phone : " + phoneNumber + " \n Total Price : " + price + "\n Product ID : " + Products;
                Intent intent =new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"mostafa_elgendy69@hotmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"My Order");
                intent.putExtra(Intent.EXTRA_TEXT,order);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("message/rfc822");
                if (userName == null || phoneNumber == null || userAddress ==null){
                    Toast.makeText(getApplicationContext(),"Fill up the Empty Field",Toast.LENGTH_LONG).show();
                }else {
                    startActivity(Intent.createChooser(intent,"Send Order"));
                }
            }
        });

        //click Listener of main menu

        Button mainMenu = (Button) findViewById(R.id.menu_id_address);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(AddressActivity.this,MainMenu.class);
                startActivity(menuIntent);
            }
        });
    }
}
