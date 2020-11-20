package com.example.golandapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductView extends AppCompatActivity {

    ProductsDBHelper productsDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        ImageView imageView = (ImageView)findViewById(R.id.image_view);
        TextView textView = (TextView)findViewById(R.id.text_view1);
        TextView producerView = (TextView)findViewById(R.id.producer_name);
        ImageView ComLogo = (ImageView)findViewById(R.id.producer_image) ;

        final Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){

            imageView.setImageResource(mBundle.getInt("ProductImage"));
            textView.setText(mBundle.getInt("ProductPrice")+"");
            producerView.setText(mBundle.getString("ProducerName"));
            ComLogo.setImageResource(mBundle.getInt("CompanyLogo"));
        }

        final SharedPreferences preferences = getSharedPreferences("user_details",MODE_PRIVATE);

        Button cartButton = (Button)findViewById(R.id.add_to_cart_id);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productsDBHelper = new ProductsDBHelper(ProductView.this);

                int userID = preferences.getInt("userID",0);
                int price = mBundle.getInt("ProductPrice");
                int productId = mBundle.getInt("ProductId");
               // Intent cartIntent = new Intent(ProductView.this,CartActivities.class);
               productsDBHelper.insertToCart(price,productId,userID);

                Toast.makeText(getApplicationContext(),"Product is Added To Cart Successfully",Toast.LENGTH_LONG).show();


            }
        });
        //click Listener of main menu

        Button mainMenu = (Button) findViewById(R.id.menu_id_proview);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(ProductView.this,MainMenu.class);
                startActivity(menuIntent);
            }
        });


        // click Listener of cart button

        Button cart = (Button)findViewById(R.id.cart_id);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartIntent = new Intent(ProductView.this,CartActivities.class);
                startActivity(cartIntent);
            }
        });
    }
}
