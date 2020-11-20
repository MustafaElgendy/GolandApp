package com.example.golandapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    ProductsDBHelper db;
    EditText e1,e2,e3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        db = new ProductsDBHelper(this);
        e1=(EditText)findViewById(R.id.emailText2);
        e2 =(EditText)findViewById(R.id.passwordText2);
        e3 = (EditText)findViewById(R.id.confirm_passwordText2);
        b1 = (Button)findViewById(R.id.register);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields the empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3)){
                        Boolean checkMail = db.checkMail(s1);
                        if(checkMail == true){
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();
                                Intent logIntent = new Intent(SignUpActivity.this,MainActivity.class);
                                startActivity(logIntent);
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Already Exsists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Password not Matching.... Try again!! ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public Cursor getData(){
        SQLiteDatabase db1 = db.getReadableDatabase();
        Cursor cursor = db1.rawQuery("Select * from user ",null);

        return cursor;
    }
}
