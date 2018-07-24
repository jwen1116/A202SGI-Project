package com.example.user.travelbuddy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomSwipeAdapter extends PagerAdapter {

    private int[] mImages = new int[]{
            R.drawable.kekloksi_new,
            R.drawable.avatarsecretgraden_new,
            R.drawable.penanghill_new,
            R.drawable.streetart_new,
            R.drawable.snaketemple_new,
            R.drawable.entopia_new,
            R.drawable.hawkerfood_new
    };
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CustomSwipeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = mLayoutInflater.inflate(R.layout.fragment_attraction_2, container, false);
        ImageView imageview = (ImageView) item_view.findViewById(R.id.image_view);
        imageview.setImageResource(mImages[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}



