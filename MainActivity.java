package com.example.cropconnect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button addCropBtn, viewCropsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCropBtn = findViewById(R.id.addCropBtn);
        viewCropsBtn = findViewById(R.id.viewCropsBtn);

        addCropBtn.setOnClickListener(v -> startActivity(new Intent(this, AddCropActivity.class)));
        viewCropsBtn.setOnClickListener(v -> startActivity(new Intent(this, CropListActivity.class)));
    }
}
