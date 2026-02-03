package com.example.sr23bscs025;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sharedpreferences2 extends AppCompatActivity {
    TextView tv_msg;
    EditText et_age;
    SharedPreferences objSP;
    Button remove,next;
    RadioGroup rg;
    RadioButton rb;
    SharedPreferences.Editor editor;

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
           rg=findViewById(R.id.ragdiogroup);
           tv_msg=findViewById(R.id.textView5);
           et_age=findViewById(R.id.editTextAge);
           remove =findViewById(R.id.button7);
           next=findViewById(R.id.button8);

           objSP = getSharedPreferences("spDetails_ap",MODE_PRIVATE);
           if(objSP.contains("sp_name")){
               String data=objSP.getString("sp_name",null);
               tv_msg.setText("data: "+data);

           }
           else{
               tv_msg.setText("no data recieved");
           }

           next.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String age = et_age.getText().toString();


                   //use editor to write by calling the editor class and creating its object
                    editor = objSP.edit();

                   //use put command to put relevant data just like intent in key-value pairs
                   editor.putString("sp_age",age);

                   //commit or apply changes , missing this won't write
                   editor.apply();

                   Intent i = new Intent(sharedpreferences2.this, sharedPreferences3.class) ;
                   startActivity(i);
               }
           });

           remove.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int selectedId=rg.getCheckedRadioButtonId();
                   if(selectedId==-1){
                       Toast.makeText(sharedpreferences2.this,"Select an option",Toast.LENGTH_SHORT).show();
                       return;
                   }
                   rb=findViewById(selectedId);
                   String confirm = rb.getText().toString();
                   if(confirm.equals("remove")){
                       editor.remove("sp_name");
                       Toast.makeText(sharedpreferences2.this, "name Removed !!", Toast.LENGTH_SHORT).show();
                      // tv_msg.setText("removed");
                   } else if (confirm.equals("clear")) {
                       editor.clear();
                       Toast.makeText(sharedpreferences2.this, "All Removed !!", Toast.LENGTH_SHORT).show();

                   }
                   editor.commit();
                   Intent itxt = new Intent(sharedpreferences2.this, sharedPreferences3.class);
                   startActivity(itxt);

               }
           });





       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }


}
