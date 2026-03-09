package com.example.cropconnect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FarmerActivity extends AppCompatActivity {

    EditText cropName, cropPrice, phoneNumber;
    Button saveBtn, viewCropsBtn;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

        cropName = findViewById(R.id.cropName);
        cropPrice = findViewById(R.id.cropPrice);
        phoneNumber = findViewById(R.id.phoneNumber);

        saveBtn = findViewById(R.id.saveBtn);
        viewCropsBtn = findViewById(R.id.viewCropsBtn);

        dbHelper = new DatabaseHelper(this);

        saveBtn.setOnClickListener(v -> {

            String name = cropName.getText().toString();
            String price = cropPrice.getText().toString();
            String phone = phoneNumber.getText().toString();

            if(name.isEmpty() || price.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this,"Enter all fields",Toast.LENGTH_SHORT).show();
                return;
            }

            dbHelper.addCrop(name,price,phone);

            Toast.makeText(this,"Crop Saved",Toast.LENGTH_SHORT).show();

            cropName.setText("");
            cropPrice.setText("");
            phoneNumber.setText("");
        });

        viewCropsBtn.setOnClickListener(v -> {

            Intent intent = new Intent(FarmerActivity.this, CropListActivity.class);
            startActivity(intent);

        });
    }
}
