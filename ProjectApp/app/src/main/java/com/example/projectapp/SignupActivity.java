package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    TextView txtDangNhap;
    Button btnCreateAccount;
    EditText edtUserName, edtUserEmail, edtUserPW, edtUserConfirmPW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this,"Chào mừng bạn đã quay lại với Hygge",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, email, pw, confirmpw;
                name = edtUserName.getText().toString();
                email = edtUserEmail.getText().toString();
                pw = edtUserPW.getText().toString();
                confirmpw = edtUserConfirmPW.getText().toString();
                if(name.length()==0 || email.length() == 0 || pw.length() == 0 || confirmpw.length()==0){
                    Toast.makeText(SignupActivity.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
                }else {
                    if(pw.length()<6){
                        Toast.makeText(SignupActivity.this,"Mật khẩu của bạn quá ngắn, hãy nhập nhiều hơn 6 kí tự",Toast.LENGTH_LONG).show();
                    }else if(!pw.equals(confirmpw)){
                        Toast.makeText(SignupActivity.this,"Xác nhận mật khẩu không đúng",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(SignupActivity.this, "Đăng ký thành công!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignupActivity.this, Choose_user.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void linkViews() {
        txtDangNhap = findViewById(R.id.txtDangNhap);
        btnCreateAccount  =findViewById(R.id.btnCreateAccount);
        edtUserName = findViewById(R.id.edtUserName);
        edtUserEmail = findViewById(R.id.edtUserEmail);
        edtUserPW = findViewById(R.id.edtUserPW);
        edtUserConfirmPW = findViewById(R.id.edtUserConfirmPW);
    }




}