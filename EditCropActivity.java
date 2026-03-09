package com.example.cropconnect;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditCropActivity extends AppCompatActivity {

    EditText editCropName, editCropPrice;
    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_crop);

        editCropName = findViewById(R.id.editCropName);
        editCropPrice = findViewById(R.id.editCropPrice);
        updateBtn = findViewById(R.id.updateBtn);

        updateBtn.setOnClickListener(v -> {
            Toast.makeText(this,"Update clicked",Toast.LENGTH_SHORT).show();
        });
    }
}
