package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    Button btnDangNhap, btnSigninBack;
    TextView txtQuenMK;
    EditText edtEmailDN, edtPWDN;
    String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        linkViews();
        getData();
        addEvents();
    }

    private void getData() {
        Intent intent = getIntent();
        role = intent.getStringExtra("role");
    }

    private void addEvents() {
        btnSigninBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, pw;
                email = edtEmailDN.getText().toString();
                pw = edtPWDN.getText().toString();
                if(email.length() == 0 || pw.length() == 0){
                    Toast.makeText(SigninActivity.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
                }else {
                    if (role.equals("BN")) {
                        Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    if (role.equals("BS")){
                        Intent intent = new Intent(SigninActivity.this, MainActivity_Bs.class);
                        startActivity(intent);
                    }
                }

            }
        });
        txtQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (role.equals("BS")){
                    Intent intent = new Intent(SigninActivity.this, ForgotPW_activity.class);
                    intent.putExtra("role","BS");
                    startActivity(intent);
                }
                if (role.equals("BN")){
                    Intent intent = new Intent(SigninActivity.this, ForgotPW_activity.class);
                    intent.putExtra("role","BN");
                    startActivity(intent);
                }
            }
        });
    }

    private void linkViews() {
        btnDangNhap = findViewById(R.id.btnDangNhap);
        txtQuenMK = findViewById(R.id.txtQuenMK);
        edtEmailDN = findViewById(R.id.edtEmailDN);
        edtPWDN = findViewById(R.id.edtPWDN);
        btnSigninBack = findViewById(R.id.btnSigninBack);
    }
}