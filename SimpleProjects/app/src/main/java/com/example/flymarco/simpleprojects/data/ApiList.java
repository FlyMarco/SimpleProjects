package com.example.flymarco.simpleprojects.data;

import com.example.flymarco.simpleprojects.MainActivity;
import com.example.flymarco.simpleprojects.recyclerview.data.RecyclerViewApi;

import java.util.Arrays;
import java.util.List;

public class ApiList {

    public static final Class DEFAULT_ACTIVITY = MainActivity.class;
    private static Class mStartActivity = DEFAULT_ACTIVITY;

    public static List<BaseApi> getData() {
        return sData;
    }

    public static BaseApi getCurrentData() {
        if (INDEX_START_ACTIVITY < 0) {
            INDEX_START_ACTIVITY = 0;
        } else if (INDEX_START_ACTIVITY >= sData.size()) {
            INDEX_START_ACTIVITY = sData.size() - 1;
        }

        return sData.get(INDEX_START_ACTIVITY);
    }

    private static int INDEX_START_ACTIVITY = 0;

    private static final List<BaseApi> sData = Arrays.asList(new BaseApi[]{
            new RecyclerViewApi(),
            new RecyclerViewApi(),
            new RecyclerViewApi(),
            new RecyclerViewApi(),
            new RecyclerViewApi(),
            new RecyclerViewApi(),
            new RecyclerViewApi(),
            new RecyclerViewApi(),
            new RecyclerViewApi()
    });

    public static Class getStartActivity() {
        return mStartActivity;
    }

    public static void setStartActivity(Class startActivity) {
        mStartActivity = startActivity;
    }
}
