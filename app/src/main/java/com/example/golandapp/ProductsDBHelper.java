package com.example.golandapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ProductsDBHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "ProductsDB.db";
    private static final int DB_Version = 1;
    public ProductsDBHelper(Context context ) {
        super(context, DB_Name, null, DB_Version);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlProducts = "CREATE TABLE products(id INTEGER PRIMARY KEY AUTOINCREMENT, price INTEGER , image INTEGER,CompanyName VARCHAR , CompanyLogo INTEGER);";
        db.execSQL("Create table user(userId INTEGER PRIMARY KEY AUTOINCREMENT, email text, password text)");
        String sqlCart = "CREATE TABLE cartProducts(idCart INTEGER PRIMARY KEY AUTOINCREMENT, price INTEGER ,productsId INTEGER,userID INTEGER,FOREIGN KEY(productsId) REFERENCES products(id),FOREIGN KEY(userID) REFERENCES user(userId));";


        db.execSQL(sqlProducts);
        db.execSQL(sqlCart);
    }

    public void addProduct(int price , String Desc,int image , int companyLogo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("price",price);
        contentValues.put("image",image);
        contentValues.put("CompanyName",Desc);
        contentValues.put("CompanyLogo",companyLogo);
        long x = db.insert("products",null,contentValues);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlProducts ="DROP TABLE IF EXISTS products";
        String sqlCart ="DROP TABLE IF EXISTS cartProducts";
        db.execSQL(sqlCart);
        db.execSQL(sqlProducts);
        onCreate(db);
    }
    public ArrayList<CardContent> loadProductsHandler(String TABLE_NAME, int keyPosition,int keyPosition2) {
        ArrayList<CardContent> result = new ArrayList<CardContent>() {};
        try {

        String query = "Select * FROM " + TABLE_NAME + " where id  BETWEEN " + keyPosition + " AND " + keyPosition2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            int result_1 = cursor.getInt(1);
            int result_2 = cursor.getInt(2);
            String result_3 = cursor.getString(3);
            int result_4 = cursor.getInt(4);
            CardContent x = new CardContent(result_2,result_1,result_0,result_3,result_4);
            result.add(x);
        }
        cursor.close();
        db.close();

        }catch (Exception t){
            t.getMessage();
        }
        return result;
    }
    public void deleteProductsHandler( String TABLE_NAME) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);

    }
    // rerieve all products data from database

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from products",null);
        return cursor;
    }
    public boolean insert(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins == -1)return false;
        else return true;
    }
    //checking if email exists
    public Boolean checkMail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email =?",new String[]{email});
        if(cursor.getCount()>0)return false;
        else return true;

    }

    public int chkMailPassword(String email , String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        int userID = 0;
        if(cursor.getCount()>0){
            if (cursor.moveToNext()) {
                userID = cursor.getInt(0);

            }
            return userID;
        }
        else return userID;
    }


    public boolean insertToCart(int price,int productId,int userId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("price",price);
        contentValues.put("productsId",productId);
        contentValues.put("userID", userId);
        long insert = db.insert("cartProducts",null,contentValues);
        if(insert == -1)return false;
        else return true;

    }
    public ArrayList<CardContent> loadCartHandler(String TABLE_NAME , int userid) {
        ArrayList<CardContent> result = new ArrayList<CardContent>() {};

        String query = "Select * FROM " + TABLE_NAME + " JOIN products On cartProducts.productsId = products.id Where userID = " + userid;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);


        while (cursor.moveToNext()) {
            int cartID = cursor.getInt(0);
            int pPrice = cursor.getInt(1);
            int ProductID = cursor.getInt(2);
            int userID = cursor.getInt(3);
            int image = cursor.getInt(6);


            CardContent x = new CardContent(cartID,pPrice,ProductID,userID,image);
            result.add(x);
        }
        cursor.close();
        db.close();
        return result;
    }
    public void deleteProductsCart( String TABLE_NAME , int cartID) {
        try{
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME + " Where idCart = " + cartID);}
        catch ( Exception r){
            r.getMessage();
        }

    }
    public Cursor getDataFromCart(int userId){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from cartProducts Where userID = " + userId,null);
        return cursor;
    }




}
