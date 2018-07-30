package com.example.flymarco.simpleprojects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.flymarco.simpleprojects.recyclerview.adapter.ApiAdapter;
import com.example.flymarco.simpleprojects.recyclerview.itemdecoration.BaseItemDecoration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rcy_list);
        recyclerView.setAdapter(new ApiAdapter(this));
        recyclerView.addItemDecoration(new BaseItemDecoration(this, BaseItemDecoration.LAYOUT_VERTAIL));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

}
