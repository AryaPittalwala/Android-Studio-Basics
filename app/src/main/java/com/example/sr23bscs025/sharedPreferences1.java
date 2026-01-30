package com.example.sr23bscs025;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sharedPreferences1 extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preferences1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et = findViewById(R.id.editTextSP);
    }

    public void fnsharedPref(View view)
    {

        String name = et.getText().toString();
        //create a shared preference object and give a name
        SharedPreferences objShared = getSharedPreferences("spDetails_ap",MODE_PRIVATE);

        //use editor to write by calling the editor class and creating its object
        SharedPreferences.Editor editor = objShared.edit();

        //use put command to put relevant data just like intent in key-value pairs
        editor.putString("sp_name",name);

        //commit or apply changes , missing this won't write
        editor.commit();

        Intent intent = new Intent(this, sharedpreferences2.class);
        startActivity(intent);
    }
}