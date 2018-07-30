package com.example.flymarco.simpleprojects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.flymarco.simpleprojects.data.ApiList;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class startActivity = ApiList.getStartActivity();
        Intent intent = new Intent();
        intent.setClass(StartActivity.this, startActivity);
        startActivity(intent);
    }
}
