package com.example.cropconnect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText farmerUsername, farmerPassword, buyerUsername, buyerPassword;
    Button farmerLoginBtn, buyerLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        farmerUsername = findViewById(R.id.farmerUsername);
        farmerPassword = findViewById(R.id.farmerPassword);
        buyerUsername = findViewById(R.id.buyerUsername);
        buyerPassword = findViewById(R.id.buyerPassword);

        farmerLoginBtn = findViewById(R.id.farmerLoginBtn);
        buyerLoginBtn = findViewById(R.id.buyerLoginBtn);

        // Farmer login -> FarmerActivity
        farmerLoginBtn.setOnClickListener(v -> {
            if(farmerUsername.getText().toString().equals("farmer") &&
                    farmerPassword.getText().toString().equals("1234")) {
                startActivity(new Intent(LoginActivity.this, FarmerActivity.class));
            } else {
                Toast.makeText(this, "Invalid farmer login", Toast.LENGTH_SHORT).show();
            }
        });

        // Buyer login -> BuyerActivity
        buyerLoginBtn.setOnClickListener(v -> {
            if(buyerUsername.getText().toString().equals("buyer") &&
                    buyerPassword.getText().toString().equals("1234")) {
                startActivity(new Intent(LoginActivity.this, BuyerActivity.class));
            } else {
                Toast.makeText(this, "Invalid buyer login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
