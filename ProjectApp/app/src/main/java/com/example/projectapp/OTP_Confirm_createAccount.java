package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTP_Confirm_createAccount extends AppCompatActivity {
    EditText edtOTP_confirm;
    Button btnConfirm_createAccount, btnConfirmAccountBack;
    String role;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_confirm_create_account);
        
        linkViews();
        getData();
        addEvents();
    }

    private void linkViews() {
        edtOTP_confirm = findViewById(R.id.edtOTP_confirm);
        btnConfirm_createAccount = findViewById(R.id.btnConfirm_create);
        btnConfirmAccountBack = findViewById(R.id.btnConfirmAccountBack);
    }

    private void getData() {
        Intent intent = getIntent();
        role = intent.getStringExtra("role");
    }

    private void addEvents() {
        btnConfirmAccountBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnConfirm_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String OTP = edtOTP_confirm.getText().toString();
                if(OTP.length()==0){
                    Toast.makeText(OTP_Confirm_createAccount.this,"Vui lòng nhập mã OTP. Nếu chưa có hãy yêu cầu Gửi lại",Toast.LENGTH_LONG).show();
                }else
                if (role.equals("BN")){
                    Toast.makeText(OTP_Confirm_createAccount.this,"Đăng ký thành công!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(OTP_Confirm_createAccount.this, Choose_user.class);
                    startActivity(intent);
                }else
                if (role.equals("BS")){
                    Toast.makeText(OTP_Confirm_createAccount.this,"Đăng ký thành công!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(OTP_Confirm_createAccount.this, Createprofile_bs_Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}