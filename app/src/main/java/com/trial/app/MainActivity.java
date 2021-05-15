package com.trial.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Model> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        models.add(new Model("DrinknDrive","No","check"));
        models.add(new Model("Over Speeding","5","error"));
        models.add(new Model("Rash Driving","3","error"));
        models.add(new Model("Dangerous Overtake","2","error"));
        models.add(new Model("Falling Asleep","0","check"));
        models.add(new Model("Traffic light Jumping","0","check"));
        models.add(new Model("Dangerous Lane Change","2","error"));
        models.add(new Model("Bad Weather","0","check"));
        models.add(new Model("Mobile Phone Distraction","2","error"));
        models.add(new Model("Pedestrian/Animal cross","5","error"));
        adapter=new SummeryAdopter(models,this);
        recyclerView.setAdapter(adapter);

    }

    private void init() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        recyclerView=findViewById(R.id.recycler_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        models=new ArrayList<>();
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}