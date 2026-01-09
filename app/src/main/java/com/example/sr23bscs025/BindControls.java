package com.example.sr23bscs025;

import android.annotation.SuppressLint;
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

public class BindControls extends AppCompatActivity {
    EditText et_userName, et_userEmail;
    Button btn_sumbit;
    RadioButton rb;
    RadioGroup rg ;
    TextView tv_user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bind_controls);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_userName = findViewById(R.id.editTextUserName);
        et_userEmail=findViewById(R.id.editTextTextUserEmail);
        btn_sumbit = findViewById(R.id.btnUserSubmit);
        tv_user = findViewById(R.id.textViewUser);
        rg=findViewById(R.id.RadioGroupGender);


    }
    public void fnDisplay(View view){
        try {
            int id = rg.getCheckedRadioButtonId();
            rb = findViewById(id);
            String name = et_userName.getText().toString();
            String email =et_userEmail.getText().toString();
            String gender = rb.getText().toString();

            String result = "Name of the user is :"+name+"\nThis is the User email: "+email+"\n Gender:  "+gender;
            tv_user.setText(result);
            Toast.makeText(this,"heyyyy",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}