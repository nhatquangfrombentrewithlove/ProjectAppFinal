package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot_password extends AppCompatActivity {
    Button btnResetPW;
    TextView txtGuiMa;
    EditText edtEmailKP, edtOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        txtGuiMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmailKP.getText().toString();
                if(email.length() == 0){
                    Toast.makeText(Forgot_password.this,"Bạn chưa nhập địa chỉ email",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Forgot_password.this,"Mã OTP đã được gửi, vui lòng kiểm tra Email/SĐT",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnResetPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, OTP;
                email = edtEmailKP.getText().toString();
                OTP = edtOTP.getText().toString();
                if(email.length() == 0){
                    Toast.makeText(Forgot_password.this,"Bạn chưa nhập địa chỉ email",Toast.LENGTH_LONG).show();
                }else if(OTP.length() == 0){
                    Toast.makeText(Forgot_password.this,"Bạn chưa nhập mã OTP",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Forgot_password.this,"Mật khẩu mới đã được gửi qua Email/SĐT. Vui lòng đăng nhập lại",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Forgot_password.this, SigninActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void linkViews() {
        btnResetPW = findViewById(R.id.btnResetPW);
        txtGuiMa = findViewById(R.id.txtGuiMa);
        edtEmailKP = findViewById(R.id.edtEmailKP);
        edtOTP = findViewById(R.id.edtOTP);
    }
}