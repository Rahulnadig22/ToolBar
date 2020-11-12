package com.Nextstacks.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {
    public static String commonText = "TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        Toolbar mbToolbar = findViewById(R.id.bottom_toolBar);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        setSupportActionBar(mbToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Check Your Details");
        }
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String text = "";

                if(item.getItemId()==R.id.action_home){
                    text = "You Are viewing Home Page";

                }else if(item.getItemId()==R.id.action_explore){
                    text = "You are viewing Explorer page";

                }else if(item.getItemId()==R.id.action_fitness){
                    text = "You are viewing Fitness page";

                }else if(item.getItemId()==R.id.action_cloudUpload){
                    text = "You are viewing Cloud Upload page";

                }else if(item.getItemId()==R.id.action_settings){
                    text = "You are viewing Settings page";
                }
                fragment_bottomNav frag =new fragment_bottomNav();
                Bundle data = new Bundle();
                data.putString(commonText,text);
                frag.setArguments(data);
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_bnav,frag);
                fm.addToBackStack(null);
                fm.commit();
                return true;
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }

        return true;
    }
}