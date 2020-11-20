package com.example.golandapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    ProductsDBHelper productsHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.card_list_2);


// add Products to ProductsDBHelper dataBase


            productsHelper = new ProductsDBHelper(this);
            /*productsHelper.deleteProductsHandler("products");
            productsHelper.addProduct(20, "Cubes", R.drawable.a1, R.drawable.cubeslogo);
            productsHelper.addProduct(120, "Cubes", R.drawable.b, R.drawable.cubeslogo);
            productsHelper.addProduct(24, "Craftmania", R.drawable.c1, R.drawable.craftmaina);
            productsHelper.addProduct(15, "Craftmania", R.drawable.d, R.drawable.craftmaina);
            productsHelper.addProduct(96, "Dragon", R.drawable.e1, R.drawable.dragon);
            productsHelper.addProduct(78, "Fapreca", R.drawable.f1, R.drawable.fapreca);
            productsHelper.addProduct(54, "Islamic Store", R.drawable.g1, R.drawable.islamic);
            productsHelper.addProduct(60, "Fapreca", R.drawable.h, R.drawable.fapreca);
            productsHelper.addProduct(100, "Dragon", R.drawable.i, R.drawable.dragon);
            productsHelper.addProduct(55, "Islamic Store", R.drawable.j1, R.drawable.islamic);*/

            ArrayList<CardContent> cards2 = new ArrayList<CardContent>();
            cards2 = productsHelper.loadProductsHandler("products",441,450);
       /* cards2.add(new CardContent(R.drawable.f1,"80$"));
        cards2.add(new CardContent(R.drawable.g1,"120$"));
        cards2.add(new CardContent(R.drawable.h,"150$"));
        cards2.add(new CardContent(R.drawable.i,"10$"));
        cards2.add(new CardContent(R.drawable.j1,"45$"));
        cards2.add(new CardContent(R.drawable.a1,"20$"));
        cards2.add(new CardContent(R.drawable.b,"25$"));
        cards2.add(new CardContent(R.drawable.c1,"50$"));
        cards2.add(new CardContent(R.drawable.d,"70$"));
        cards2.add(new CardContent(R.drawable.e1,"55$"));*/

            CardAdapter adapter2 = new CardAdapter(this, cards2);

            ListView listView2 = (ListView) findViewById(R.id.card_list2);
            listView2.setAdapter(adapter2);
            listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Cursor cursor = productsHelper.getAllData();

                    for (int i = 0; i <= parent.getCount(); i++) {

                        if (position == i) {
                            cursor.moveToPosition(i);
                            int productID = cursor.getInt(0);
                            int price = cursor.getInt(1);
                            int image1 = cursor.getInt(2);
                            String producer = cursor.getString(3);
                            int logo = cursor.getInt(4);
                            Toast.makeText(getApplicationContext(), "price is " + price, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(HomePageActivity.this, ProductView.class);
                            intent.putExtra("ProductId",productID);
                            intent.putExtra("ProductPrice", price);
                            intent.putExtra("ProductImage", image1);
                            intent.putExtra("ProducerName", producer);
                            intent.putExtra("CompanyLogo", logo);
                            startActivity(intent);
                        }
                    }
                }
            });

           /* productsHelper.deleteProductsHandler("products");
            productsHelper.addProduct(80, "Cubes", R.drawable.hmf1, R.drawable.cubeslogo);
            productsHelper.addProduct(50, "Cubes", R.drawable.hmf2, R.drawable.cubeslogo);
            productsHelper.addProduct(300, "Craftmania", R.drawable.hmf3, R.drawable.craftmaina);
            productsHelper.addProduct(150, "Craftmania", R.drawable.hmf4, R.drawable.craftmaina);
            productsHelper.addProduct(250, "Cubes", R.drawable.hmf5, R.drawable.cubeslogo);
            productsHelper.addProduct(180, "Fapreca", R.drawable.hmf6, R.drawable.fapreca);
            productsHelper.addProduct(230, "Cubes", R.drawable.hmf7, R.drawable.cubeslogo);
            productsHelper.addProduct(100, "Fapreca", R.drawable.hmf8, R.drawable.fapreca);
            productsHelper.addProduct(90, "Craftmania", R.drawable.hmf9, R.drawable.craftmaina);*/



            ArrayList<CardContent> cards3 = new ArrayList<CardContent>();
            cards3 = productsHelper.loadProductsHandler("products",451,459);
       /* cards3.add(new CardContent(R.drawable.a1,"20$"));
        cards3.add(new CardContent(R.drawable.i,"10$"));
        cards3.add(new CardContent(R.drawable.j1,"45$"));
        cards3.add(new CardContent(R.drawable.d,"70$"));
        cards3.add(new CardContent(R.drawable.e1,"55$"));
        cards3.add(new CardContent(R.drawable.f1,"80$"));
        cards3.add(new CardContent(R.drawable.g1,"120$"));
        cards3.add(new CardContent(R.drawable.b,"25$"));
        cards3.add(new CardContent(R.drawable.c1,"50$"));
        cards3.add(new CardContent(R.drawable.h,"150$"));*/
            CardAdapter adapter3 = new CardAdapter(this, cards3);

            ListView listView3 = (ListView) findViewById(R.id.card_list3);
            listView3.setAdapter(adapter3);
            listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Cursor cursor = productsHelper.getAllData();

                    for (int i = 0; i <= parent.getCount(); i++) {

                        if (position == i) {
                            cursor.moveToPosition(i+10);
                            int productID = cursor.getInt(0);
                            int price = cursor.getInt(1);
                            int image1 = cursor.getInt(2);
                            String producer = cursor.getString(3);
                            int logo = cursor.getInt(4);
                            Toast.makeText(getApplicationContext(), "price is " + price, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(HomePageActivity.this, ProductView.class);
                            intent.putExtra("ProductId",productID);
                            intent.putExtra("ProductPrice", price);
                            intent.putExtra("ProductImage", image1);
                            intent.putExtra("ProducerName", producer);
                            intent.putExtra("CompanyLogo", logo);
                            startActivity(intent);
                        }
                    }
                }
            });


           /* productsHelper.deleteProductsHandler("products");
            productsHelper.addProduct(90, "Cubes", R.drawable.hmg1, R.drawable.cubeslogo);
            productsHelper.addProduct(20, "Cubes", R.drawable.hmg2, R.drawable.cubeslogo);
            productsHelper.addProduct(200, "Craftmania", R.drawable.hmg3, R.drawable.craftmaina);
            productsHelper.addProduct(80, "Craftmania", R.drawable.hmg4, R.drawable.craftmaina);
            productsHelper.addProduct(100, "Dragon", R.drawable.hmg5, R.drawable.dragon);
            productsHelper.addProduct(120, "Fapreca", R.drawable.hmg6, R.drawable.fapreca);
            productsHelper.addProduct(85, "Cubes", R.drawable.hmg7, R.drawable.cubeslogo);
            productsHelper.addProduct(120, "Fapreca", R.drawable.hmg8, R.drawable.fapreca);
            productsHelper.addProduct(250, "Dragon", R.drawable.hmg9, R.drawable.dragon);
            productsHelper.addProduct(190, "Cubes", R.drawable.hmg10, R.drawable.cubeslogo);
            productsHelper.addProduct(800, "Cubes", R.drawable.hmg11, R.drawable.cubeslogo);*/


//________________
            ArrayList<CardContent> cards = new ArrayList<CardContent>();
            cards = productsHelper.loadProductsHandler("products",460,470);
     /*   cards.add(new CardContent(R.drawable.a1,"20$"));
        cards.add(new CardContent(R.drawable.b,"25$"));
        cards.add(new CardContent(R.drawable.c1,"50$"));
        cards.add(new CardContent(R.drawable.d,"70$"));
        cards.add(new CardContent(R.drawable.e1,"55$"));
        cards.add(new CardContent(R.drawable.f1,"80$"));
        cards.add(new CardContent(R.drawable.g1,"120$"));
        cards.add(new CardContent(R.drawable.h,"150$"));
        cards.add(new CardContent(R.drawable.i,"10$"));
        cards.add(new CardContent(R.drawable.j1,"45$"));
*/
            CardAdapter adapter = new CardAdapter(this, cards);

            ListView listView = (ListView) findViewById(R.id.card_list1);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Cursor cursor = productsHelper.getAllData();

                    for (int i = 0; i <= parent.getCount(); i++) {

                        if (position == i) {
                            cursor.moveToPosition(i+19);
                            int productID = cursor.getInt(0);
                            int price = cursor.getInt(1);
                            int image1 = cursor.getInt(2);
                            String producer = cursor.getString(3);
                            int logo = cursor.getInt(4);
                            Toast.makeText(getApplicationContext(), "price is " + price, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(HomePageActivity.this, ProductView.class);
                            intent.putExtra("ProductId",productID);
                            intent.putExtra("ProductPrice", price);
                            intent.putExtra("ProductImage", image1);
                            intent.putExtra("ProducerName", producer);
                            intent.putExtra("CompanyLogo", logo);
                            startActivity(intent);
                        }
                    }



                /*if (position == 0){
                    Cursor cursor = productsHelper.getAllData();
                    cursor.moveToPosition(0);
                    String price1 = cursor.getString(1);
                    int image1 = cursor.getInt(2);
                    Toast.makeText(getApplicationContext(), "price is " + price1, Toast.LENGTH_SHORT).show();

                    ImageView imageView1 = (ImageView)findViewById(R.id.image_view);
                    imageView1.setImageResource(image1);
                    TextView priceView = (TextView)findViewById(R.id.text_view1);
                    priceView.setText(price1);
                    Intent intent = new Intent(HomePageActivity.this,ProductView.class);
                    startActivity(intent);


                }else{
                    Intent intent = new Intent(HomePageActivity.this,ProductView.class);
                    startActivity(intent);
                }*/


                }
            });

            //??????????????????
           /* productsHelper.deleteProductsHandler("products");
            productsHelper.addProduct(20, "Cubes", R.drawable.a1, R.drawable.cubeslogo);
            productsHelper.addProduct(120, "Cubes", R.drawable.b, R.drawable.cubeslogo);
            productsHelper.addProduct(24, "Craftmania", R.drawable.c1, R.drawable.craftmaina);
            productsHelper.addProduct(15, "Craftmania", R.drawable.d, R.drawable.craftmaina);
            productsHelper.addProduct(96, "Dragon", R.drawable.e1, R.drawable.dragon);
            productsHelper.addProduct(78, "Fapreca", R.drawable.f1, R.drawable.fapreca);
            productsHelper.addProduct(54, "Islamic Store", R.drawable.g1, R.drawable.islamic);
            productsHelper.addProduct(60, "Fapreca", R.drawable.h, R.drawable.fapreca);
            productsHelper.addProduct(100, "Dragon", R.drawable.i, R.drawable.dragon);
            productsHelper.addProduct(55, "Islamic Store", R.drawable.j1, R.drawable.islamic);
            //
            productsHelper.addProduct(80, "Cubes", R.drawable.hmf1, R.drawable.cubeslogo);
            productsHelper.addProduct(50, "Cubes", R.drawable.hmf2, R.drawable.cubeslogo);
            productsHelper.addProduct(300, "Craftmania", R.drawable.hmf3, R.drawable.craftmaina);
            productsHelper.addProduct(150, "Craftmania", R.drawable.hmf4, R.drawable.craftmaina);
            productsHelper.addProduct(250, "Cubes", R.drawable.hmf5, R.drawable.cubeslogo);
            productsHelper.addProduct(180, "Fapreca", R.drawable.hmf6, R.drawable.fapreca);
            productsHelper.addProduct(230, "Cubes", R.drawable.hmf7, R.drawable.cubeslogo);
            productsHelper.addProduct(100, "Fapreca", R.drawable.hmf8, R.drawable.fapreca);
            productsHelper.addProduct(90, "Craftmania", R.drawable.hmf9, R.drawable.craftmaina);
            //
            productsHelper.addProduct(90, "Cubes", R.drawable.hmg1, R.drawable.cubeslogo);
            productsHelper.addProduct(20, "Cubes", R.drawable.hmg2, R.drawable.cubeslogo);
            productsHelper.addProduct(200, "Craftmania", R.drawable.hmg3, R.drawable.craftmaina);
            productsHelper.addProduct(80, "Craftmania", R.drawable.hmg4, R.drawable.craftmaina);
            productsHelper.addProduct(100, "Dragon", R.drawable.hmg5, R.drawable.dragon);
            productsHelper.addProduct(120, "Fapreca", R.drawable.hmg6, R.drawable.fapreca);
            productsHelper.addProduct(85, "Cubes", R.drawable.hmg7, R.drawable.cubeslogo);
            productsHelper.addProduct(120, "Fapreca", R.drawable.hmg8, R.drawable.fapreca);
            productsHelper.addProduct(250, "Dragon", R.drawable.hmg9, R.drawable.dragon);
            productsHelper.addProduct(190, "Cubes", R.drawable.hmg10, R.drawable.cubeslogo);
            productsHelper.addProduct(800, "Cubes", R.drawable.hmg11, R.drawable.cubeslogo);*/



            //click Listener of main menu

            Button mainMenu = (Button) findViewById(R.id.menu_id);
            mainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent menuIntent = new Intent(HomePageActivity.this,MainMenu.class);
                    startActivity(menuIntent);
                }
            });

            // click Listener of cart button

            Button cart = (Button) findViewById(R.id.cart_id);
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent cartIntent = new Intent(HomePageActivity.this, CartActivities.class);
                    startActivity(cartIntent);
                }
            });

        }catch (Exception t){
            t.getMessage();
        }
    }


}
