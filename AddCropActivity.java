package com.example.cropconnect;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCropActivity extends AppCompatActivity {

    EditText cropName, cropPrice, phoneNumber;
    Button addBtn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop);

        cropName = findViewById(R.id.cropName);
        cropPrice = findViewById(R.id.cropPrice);
        phoneNumber = findViewById(R.id.phoneNumber);
        addBtn = findViewById(R.id.addBtn);

        db = new DatabaseHelper(this);

        addBtn.setOnClickListener(v -> {

            String name = cropName.getText().toString();
            String price = cropPrice.getText().toString();
            String phone = phoneNumber.getText().toString();

            db.addCrop(name, price, phone);

            Toast.makeText(this, "Crop Added", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
