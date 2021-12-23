package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity_Bs extends AppCompatActivity {
    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bs);
        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_bs);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Home");
        loadFragment(new Homepage_screen());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home_bs:
                    toolbar.setTitle("Trang chủ");
                    fragment = new Homepage_screen();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_patient_bs:
                    toolbar.setTitle("Bệnh nhân");
                    fragment = new Selfhelp_Suggestion();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_rate_bs:
                    toolbar.setTitle("Đánh giá");


                    return true;
                case R.id.navigation_newsfeed_bs:
                    toolbar.setTitle("Bảng tin");
                    fragment = new BlogScreen();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account_bs:
                    toolbar.setTitle("Tài khoản");
                    fragment = new account_screen();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_bs, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}