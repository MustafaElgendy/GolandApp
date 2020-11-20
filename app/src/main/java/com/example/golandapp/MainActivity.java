package com.example.golandapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mail,pass;
    Button login;
    ProductsDBHelper db;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new ProductsDBHelper(this);
        TextView signUpT = (TextView) findViewById(R.id.link_signup);
        signUpT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSignActivity();
            }
        });
        mail = (EditText)findViewById(R.id.emailText);
        pass = (EditText)findViewById(R.id.passwordText);
        login = (Button)findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getMial = mail.getText().toString();
                String getPass = pass.getText().toString();
                int chekMailPass = db.chkMailPassword(getMial,getPass);
                if(getMial.equals("")|| getPass.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields the empty",Toast.LENGTH_SHORT).show();

                }
                else {
                    if (chekMailPass > 0){
                        try {


                        Toast.makeText(getApplicationContext(),"Loading......",Toast.LENGTH_SHORT).show();
                        preferences = getSharedPreferences("user_details",MODE_PRIVATE);

                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("mail",getMial);
                            editor.putString("password",getPass);
                            editor.putInt("userID",chekMailPass);
                            editor.commit();
                            callHomePage();
                        }
                        catch (Exception r){
                            r.getMessage();
                        }

                    }
                    else
                        Toast.makeText(getApplicationContext(),"Wrong Email or Password",Toast.LENGTH_SHORT).show();


                }

                }
            });


    }
    public void callSignActivity(){
        Intent logIntent = new Intent(this, SignUpActivity.class);
        startActivity(logIntent);
    }

    public void callHomePage(){



        Intent homeIntent = new Intent(MainActivity.this,HomePageActivity.class);
        startActivity(homeIntent);
    }
}
