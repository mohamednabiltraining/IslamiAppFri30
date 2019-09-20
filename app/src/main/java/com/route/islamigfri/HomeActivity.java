package com.route.islamigfri;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.route.islamigfri.fragments.QuranFragment;
import com.route.islamigfri.fragments.TasbeehFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView.OnNavigationItemSelectedListener
            onNavigationItemSelectedListener =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int id = menuItem.getItemId();
            Fragment fragment=null;
            switch (id){
                case R.id.navigation_quran:{
                    fragment= new QuranFragment();
                    break;
                }
                case R.id.navigation_tasbeh:{
                    fragment =new TasbeehFragment();
                    break;
                }
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_quran);

    }

}
