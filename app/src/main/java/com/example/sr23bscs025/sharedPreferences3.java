package com.example.sr23bscs025;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sharedPreferences3 extends AppCompatActivity {

    TextView tv_name ,tv_age;
    SharedPreferences objSP1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preferences3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //wscube tech
        //smart programming dr zishan bhatii
        try{
            tv_name=findViewById(R.id.textViewName1);
            tv_age =findViewById(R.id.textViewAge1);

            objSP1 = getSharedPreferences("spDetails_ap",MODE_PRIVATE);
            if(objSP1.contains("sp_name") && objSP1.contains("sp_age")){
                String name=objSP1.getString("sp_name",null);
                String age =objSP1.getString("sp_age",null);
                tv_name.setText("NAME: "+name);
                tv_age.setText("AGE: "+age);
            }
            else if(objSP1.contains("sp_age")){
                {
                    String age =objSP1.getString("sp_age",null);
                    tv_age.setText("AGE: "+age);
                    tv_name.setText("NO DATA RECIEVED");
                }

            }
            else{
                tv_name.setText("NO DATA RECIEVED");
                tv_age.setText("NO DATA RECIEVED");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}