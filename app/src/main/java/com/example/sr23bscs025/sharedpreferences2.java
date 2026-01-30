package com.example.sr23bscs025;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sharedpreferences2 extends AppCompatActivity {
    TextView tv_msg;
    EditText et_age;
    SharedPreferences objSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sharedpreferences2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       try{
           tv_msg=findViewById(R.id.textView5);
           et_age=findViewById(R.id.editTextAge);

           objSP = getSharedPreferences("spDetails_ap",MODE_PRIVATE);
           if(objSP.contains("sp_name")){
               String data=objSP.getString("sp_name",null);
               tv_msg.setText("data: "+data);
           }
           else{
               tv_msg.setText("no data recieved");
           }


       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}