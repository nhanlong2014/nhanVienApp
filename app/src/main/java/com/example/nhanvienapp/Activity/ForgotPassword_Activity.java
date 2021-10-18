package com.example.nhanvienapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nhanvienapp.R;

public class ForgotPassword_Activity extends AppCompatActivity {

    private Button btn_forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgot_password);

        btn_forgotPassword = findViewById(R.id.btn_forgot_password);
        btn_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ForgotPassword_Activity.this, ChangePassword_Activity.class);
                startActivity(i);
            }
        });
    }
}