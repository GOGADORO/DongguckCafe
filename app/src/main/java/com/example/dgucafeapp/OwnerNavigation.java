package com.example.dgucafeapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;
public class OwnerNavigation extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private OwnerHome fragHome;
    private OwnerCoupon fragCoupon;
    private OwnerMenu fragMenu;

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavOnNavigationItenSelectedListner =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_owner_home: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout, fragHome).commitAllowingStateLoss();
                    return true;
                }
                case R.id.navigation_owner_coupon: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout, fragCoupon).commitAllowingStateLoss();
                    return true;
                }
                case R.id.navigation_owner_menu: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout, fragMenu).commitAllowingStateLoss();
                    return true;
                }
                default:
                    return false;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accumulatestamp);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavOnNavigationItenSelectedListner);

        fragHome = new OwnerHome();
        fragCoupon = new OwnerCoupon();
        fragMenu = new OwnerMenu();

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_layout,fragHome).commitAllowingStateLoss();



    }
}

