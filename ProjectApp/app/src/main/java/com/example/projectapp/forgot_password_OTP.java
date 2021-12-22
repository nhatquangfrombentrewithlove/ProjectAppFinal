package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password_OTP extends Fragment {

    Button btnResetPW, btnForgotPWBack02;
    EditText edtOTP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_forgot_password_otp, container, false);
        btnResetPW = view.findViewById(R.id.btnResetPW);
        btnForgotPWBack02 = view.findViewById(R.id.btnForgotPWBack02);
        edtOTP = view.findViewById(R.id.edtOTP);

        addEvents();
        return view;
    }

    private void addEvents() {
        btnResetPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String OTP = edtOTP.getText().toString();
                if (OTP.length() == 0){
                    Toast.makeText(getActivity(),"Vui lòng nhập mã OTP. Nếu chưa có, vui lòng yêu cầu gửi lại!",Toast.LENGTH_LONG).show();
                }else {
                    forgot_password_ResetPassword fragmentPW3 = new forgot_password_ResetPassword();
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerPW_body, fragmentPW3);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        btnForgotPWBack02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forgot_password fragmentPW1 = new Forgot_password();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerPW_body, fragmentPW1);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}