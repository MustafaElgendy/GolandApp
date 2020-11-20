package com.example.golandapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<CardContent> {
    /*private Context mContext;
    private int[] mPlaceList;

    public CardAdapter(Context mContext, int[] mPlaceList) {

        this.mContext = mContext;
        this.mPlaceList = mPlaceList;
    }
    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_page,
                parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, int position) {

        holder.mPlace.setImageResource(mPlaceList[position]);

    }

    @Override
    public int getItemCount() {
        return mPlaceList.length;
    }*/


    public CardAdapter(Activity context, ArrayList<CardContent> cards) {
        super(context, 0,cards);
    }

    public View getView(int position,View convertView,ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_home_page, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        CardContent currentCard = getItem(position);

        ImageView cardImage = (ImageView)listItemView.findViewById(R.id.image_a);
        cardImage.setImageResource(currentCard.getImageResourceId());

        TextView cardText = (TextView) listItemView.findViewById(R.id.text_a);
        cardText.setText(currentCard.getProductPrice()+"");

        return listItemView;

    }


}
/*class PlaceViewHolder extends RecyclerView.ViewHolder {

    public PlaceViewHolder(View itemView) {
        super(itemView);
        ImageView mPlace = itemView.findViewById(R.id.image_a);
        TextView mText = itemView.findViewById(R.id.text_a);
    }
}*/
