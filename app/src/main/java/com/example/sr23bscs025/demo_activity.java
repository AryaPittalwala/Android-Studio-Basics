package com.example.sr23bscs025;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class demo_activity extends AppCompatActivity {
    EditText etName,etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etName=findViewById(R.id.EditTextText);
        etEmail=findViewById(R.id.editTextTextEmailAddress3);
    }

    public void fnExplicitIntent(View view){
        try{
            Intent intent =new Intent(demo_activity.this, Explicit2.class);
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            intent.putExtra("a_name",name);
            intent.putExtra("a_email",email);

            Log.d("name + email",name+" "+email);
            startActivity(intent);
        } catch (Exception e) {
            Log.e("error occurs",e.toString());
        }
    }
}