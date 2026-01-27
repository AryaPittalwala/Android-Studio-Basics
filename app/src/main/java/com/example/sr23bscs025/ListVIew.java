package com.example.sr23bscs025;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListVIew extends AppCompatActivity {
    ArrayList<String> city;
    EditText et_city;
    ListView lv_city;
    TextView tv_city;
    Button add,edit;
    ArrayAdapter<String> adp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv_city =findViewById(R.id.ListViewCity);
        et_city=findViewById(R.id.editTextCity);
        tv_city=findViewById(R.id.textView6);
        add=findViewById(R.id.btnAdd);

        city=new ArrayList<>();
//        city.add("Surat");
//        city.add("Navsari");
        adp=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,city);
        lv_city.setAdapter(adp);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city1 = "";
                city1=et_city.getText().toString();

                if(city1.length()==0){
                    tv_city.setText("DATA CANNOT BE INSERTED");
                } else if (city.contains(city1)) {
                    tv_city.setText("DATA ALREADY EXISTS");
                }
                else{
                    city.add(city1);
                    adp.notifyDataSetChanged();
                    et_city.setText("");
                    tv_city.setText("DATA ADDED");
                }
            }
        });

    }
}