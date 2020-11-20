package com.example.golandapp;

public class CardContent {
    /** product image*/
    private int imagePrimryId;
    private int imageResourceId;
    private String Desc;
    private int companayLogo1;

    /** product price */
    private int productPrice;

    public int cartProductID;
    private int ProductID;
    private int UserID;

    public CardContent(int imageId , int price, int primaryId, String Desc , int companyLogo){
        imageResourceId = imageId;
        productPrice = price;
        imagePrimryId = primaryId;
        Desc = Desc;
        companayLogo1 = companyLogo;
    }
    public CardContent(int cProductID , int price , int productID,int userID,int image){
        productPrice = price;
        cartProductID = cProductID;
        ProductID = productID;
        UserID =userID;
        imageResourceId = image;
    }

    public CardContent(int imageId , int price){
        imageResourceId = imageId;
        productPrice = price;
    }

    /** get the image of product*/
    public int getImageResourceId(){return imageResourceId; }



    /** get the price of product*/

    public int getProductPrice(){ return  productPrice;}
}


