package com.example.user.travelbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class LanguageFragment extends Fragment {
    private List<Language> LanguageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LanguageAdapter mAdapter;
    Activity context;


    public LanguageFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_language,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new LanguageAdapter(LanguageList);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context.getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareLanguageData();




        return view;
    }

    private void prepareLanguageData() {
        Language language=new Language("Where is the restroom?", "请问厕所在哪里？", "Di manakah tandas?");
        LanguageList.add(language);

        language=new Language("How much does this cost?", "这个东西多少钱？", "Apakah harga barang ini?");
        LanguageList.add(language);

        language=new Language("Can I know the way to this place?", "请问这个地方怎样去？", "Bagaimanakah pergi ke tempat ini?");
        LanguageList.add(language);

        language=new Language("Where is the bus stop?", "请问巴士站在哪里？", "Di manakah stesen bus?");
        LanguageList.add(language);

        language=new Language("I would like to order _____", "我想要点 ____", "Saya mahu order ____");
        LanguageList.add(language);

        language=new Language("Do you know where this hotel is?", "请问你知不知道这间酒店在哪里？", "Anda tahu di manakah hotel ini terletak di?");
        LanguageList.add(language);

        language=new Language("Where can I find a taxi?", "请问哪里有的士？", "Di manakh boleh saya cari taxi?");
        LanguageList.add(language);

        language=new Language("Good morning", "早安", "Selamat pagi");
        LanguageList.add(language);

        language=new Language("Good afternoon", "午安", "Selamat petang");
        LanguageList.add(language);

        language=new Language("Thank you", "谢谢", "Terima kasih");
        LanguageList.add(language);

        language=new Language("Any food recommendations?", "有什么食物介绍？", "Apakah makanan terkenal di sini?");
        LanguageList.add(language);

        language=new Language("How far is it to _____?", "这个地方远吗？", "Jauhkah tempat ini?");
        LanguageList.add(language);

        language=new Language("I need help.", "我需要帮忙。", "Saya perlu pertolongan.");
        LanguageList.add(language);

        language=new Language("I would like to change money", "我想要换钱", "Saya ingin tukar wang");
        LanguageList.add(language);

        language=new Language("Can you reduce the price？", "可以给折扣吗？", "Bolehkah harga ini dikurangkan?");
        LanguageList.add(language);

        language=new Language("I am not interested. Thank you!", "我对这个没有兴趣。谢谢！", "Saya tiada minat pada ini. Terima kasih!");
        LanguageList.add(language);

        mAdapter.notifyDataSetChanged();
    }



}
