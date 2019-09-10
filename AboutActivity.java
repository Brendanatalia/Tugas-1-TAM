package com.kel7.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        FragmentOne fragmentOne=new FragmentOne();
        ft.add(R.id.fragmentContainer,fragmentOne);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void goFragment(View view) {
        Fragment fragment=null;
        switch (view.getId()){
            case R.id.btnOne:
                fragment=new FragmentOne();
                break;
            case R.id.btnTwo:
                fragment=new FragmentTwo();
                break;
        }
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.fragmentContainer,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
