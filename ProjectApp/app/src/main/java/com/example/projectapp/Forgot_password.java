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
import android.widget.TextView;
import android.widget.Toast;

public class Forgot_password extends Fragment {
    Button btnGuiOTP, btnForgotPWBack01;
    EditText edtEmailKP;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_forgot_password, container, false);

        btnGuiOTP = view.findViewById(R.id.btnGuiOTP);
        edtEmailKP = view.findViewById(R.id.edtEmailKP);
        btnForgotPWBack01 = view.findViewById(R.id.btnForgotPWBack01);
        addEvents();
        return view;
    }

    private void addEvents() {
        btnGuiOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmailKP.getText().toString();
                if (email.length() == 0){
                    Toast.makeText(getActivity(),"Vui lòng nhập Email",Toast.LENGTH_LONG).show();
                }else {
                    forgot_password_OTP fragmentPW2 = new forgot_password_OTP();
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerPW_body, fragmentPW2);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        btnForgotPWBack01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SigninActivity.class);
                startActivity(intent);
            }
        });
    }

}