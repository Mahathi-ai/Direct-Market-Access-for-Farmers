package com.example.cropconnect;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CropListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CropAdapter adapter;
    DatabaseHelper dbHelper;
    ArrayList<Crop> cropList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DatabaseHelper(this);
        cropList = dbHelper.getAllCrops();

        // TRUE = farmer mode
        adapter = new CropAdapter(this, cropList, true);

        recyclerView.setAdapter(adapter);
    }
}
