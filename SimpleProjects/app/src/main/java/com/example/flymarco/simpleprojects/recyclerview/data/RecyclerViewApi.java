package com.example.flymarco.simpleprojects.recyclerview.data;

import android.content.Context;

import com.example.flymarco.simpleprojects.data.BaseApi;
import com.example.flymarco.simpleprojects.recyclerview.RecyclerViewActivity;

public class RecyclerViewApi implements BaseApi {
    @Override
    public String getName() {
        return "RecyclerView";
    }

    @Override
    public Class getActivityClass() {
        return RecyclerViewActivity.class;
    }

    @Override
    public void onClick(Context context) {

    }
}
