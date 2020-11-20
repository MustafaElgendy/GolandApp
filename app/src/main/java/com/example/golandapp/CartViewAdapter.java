package com.example.golandapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartViewAdapter extends ArrayAdapter<CardContent> {
    public CartViewAdapter (Activity context, ArrayList<CardContent> cards) {
        super(context, 0,cards);
    }


    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cart_view, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        CardContent currentCard = getItem(position);


        ImageView cardImage = (ImageView)listItemView.findViewById(R.id.cart_image_view);
        cardImage.setImageResource(currentCard.getImageResourceId());

        TextView cardText = (TextView) listItemView.findViewById(R.id.cart_text_view);
        cardText.setText(currentCard.getProductPrice()+"");

        return listItemView;

    }
}
