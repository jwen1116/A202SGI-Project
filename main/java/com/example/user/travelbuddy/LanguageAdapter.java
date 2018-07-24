package com.example.user.travelbuddy;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.MyViewHolder> {

    private List<Language> LanguageList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView eng_language,chinese_language,malay_language;

        public MyViewHolder(View view) {
            super(view);
            eng_language = (TextView) view.findViewById(R.id.eng_language);
            chinese_language = (TextView) view.findViewById(R.id.chinese_language);
            malay_language = (TextView) view.findViewById(R.id.malay_language);
        }
    }


    public LanguageAdapter(List<Language> LanguageList) {
        this.LanguageList = LanguageList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_language, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Language language = LanguageList.get(position);
        holder.eng_language.setText(language.getEng_language());
        holder.chinese_language.setText(language.getChinese_language());
        holder.malay_language.setText(language.getMalay_language());
    }

    @Override
    public int getItemCount() {
        return LanguageList.size();
    }
}