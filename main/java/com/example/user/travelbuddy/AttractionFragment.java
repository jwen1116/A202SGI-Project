package com.example.user.travelbuddy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class AttractionFragment extends Fragment{

    ViewPager mViewPager;
    CustomSwipeAdapter mAdapter;

    public AttractionFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attractions,container,false);
        mViewPager=view.findViewById(R.id.view_pager);
        mAdapter=new CustomSwipeAdapter(this.getActivity());
        mViewPager.setAdapter(mAdapter);


        return view;


    }

}













