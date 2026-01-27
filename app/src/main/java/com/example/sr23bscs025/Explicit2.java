package com.example.sr23bscs025;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Explicit2 extends AppCompatActivity {

    TextView tvName,tvEmail;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explicit2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvName = findViewById(R.id.textView3);
        tvEmail=findViewById(R.id.textView4);

        try {
            Intent i = getIntent();
            if(i.hasExtra("a_name")&&i.hasExtra("a_email")){
                String name = i.getStringExtra("a_name");
                String email= i.getStringExtra("a_email");

                tvName.setText(name);
                tvEmail.setText(email);

                Log.d("DATA RECIEVED",name+" "+email);
            }
            else {
                tvName.setText("No message recieved");
                tvEmail.setText("No message recieved");
            }
        } catch (Exception e) {
            Log.e("error occurs",e.toString());
        }

    }
}