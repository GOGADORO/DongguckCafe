package com.example.dgucafeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class navigation extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                case R.id.navigation_home: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout, fragHome).commitAllowingStateLoss();
                    return true;
                }
                case R.id.navigation_chart: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout, fragChart).commitAllowingStateLoss();
                    return true;
                }
                case R.id.navigation_menu: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout, fragMenu).commitAllowingStateLoss();
                    return true;
                }
                default:
                    return false;
            }
        }
    };
    private BottomNavigationView bottomNavigationView;
    private CustomerHome fragHome;
    private CustomerChart fragChart;
    private CustomerMenu fragMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavOnNavigationItemSelectedListener);

        fragHome = new CustomerHome();
        fragChart = new CustomerChart();
        fragMenu = new CustomerMenu();

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout, fragHome).commitAllowingStateLoss();
    }
}
