package com.example.sr23bscs025;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerActivity extends AppCompatActivity {

    Spinner sp_array,sp_roll; //declaration of spinner object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        try{
            sp_array = findViewById(R.id.spinner_course); //binding with id
            String[] course ={"CS","IT","BT"}; //array that consists of dropdown items
            Integer[] roll= {10,20,30}; //for int always use integer wrapper class
            ArrayAdapter<String> adtcourse = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,course);  // here in <> give the name of class of datatypes
            sp_array.setAdapter(adtcourse);

           // ArrayAdapter<Integer> adtroll = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,roll);
            // for int data type use integer wrapper class as int as primitive datatype

            //sp_roll.setAdapter(adtroll);

            sp_array.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(SpinnerActivity.this, "Item selected: "+sp_array.getSelectedItem(), Toast.LENGTH_LONG).show(); //to display selected item in toast when the value from dropdown is selected
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            }







            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}