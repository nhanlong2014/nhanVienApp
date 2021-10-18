package com.example.nhanvienapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nhanvienapp.R;

public class SignIn_Activity extends AppCompatActivity {

    private Button btn_signIn;
    private TextView txt_forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        txt_forgotPassword = findViewById(R.id.txt_forgot_password);
        btn_signIn = findViewById(R.id.btn_sign_in);

        txt_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIn_Activity.this, ForgotPassword_Activity.class);
                startActivity(i);
            }
        });

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIn_Activity.this, Main_Activity.class);
                startActivity(i);
            }
        });
    }
}