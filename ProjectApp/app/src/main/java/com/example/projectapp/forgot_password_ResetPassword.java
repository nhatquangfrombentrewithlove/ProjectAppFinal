package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password_ResetPassword extends Fragment {

    Button btnQuenMKchuyenDangNhap, btnForgotPWBack03;
    EditText edtMKmoi, edtNhapLaiMKmoi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_forgot_password_reset_password, container, false);

        btnQuenMKchuyenDangNhap = view.findViewById(R.id.btnQuenMKchuyenDangNhap);
        btnForgotPWBack03 = view.findViewById(R.id.btnForgotPWBack03);
        edtMKmoi = view.findViewById(R.id.edtMatkhaumoi);
        edtNhapLaiMKmoi = view.findViewById(R.id.edtConfirmMatkhaumoi);
        
        addEvents();
        return view;
    }

    private void addEvents() {
        btnQuenMKchuyenDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MKmoi = edtMKmoi.getText().toString();
                String NhapLaiMKmoi = edtNhapLaiMKmoi.getText().toString();
                if (MKmoi.length() == 0 ||NhapLaiMKmoi.length() == 0){
                    Toast.makeText(getActivity(),"Mật khẩu chưa được xác nhận",Toast.LENGTH_LONG).show();
                }else if (!MKmoi.equals(NhapLaiMKmoi)){
                    Toast.makeText(getActivity(),"Mật khẩu xác nhận chưa đúng",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(getActivity(), SigninActivity.class);
                    startActivity(intent);
                }
            }
        });
        btnForgotPWBack03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgot_password_OTP fragmentPW2 = new forgot_password_OTP();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerPW_body, fragmentPW2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}