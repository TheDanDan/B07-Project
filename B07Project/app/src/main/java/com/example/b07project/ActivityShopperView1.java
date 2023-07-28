package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.b07project.databinding.ActivityShopperView1Binding;

public class ActivityShopperView1 extends AppCompatActivity {

    ActivityShopperView1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShopperView1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new FragmentShopperHome());
        binding.bottomNavigationView2.setBackground(null);

        binding.bottomNavigationView2.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home)
                replaceFragment(new FragmentShopperHome());
            else if (item.getItemId() == R.id.search)
                replaceFragment(new FragmentShopperSearch());
            else
                replaceFragment(new FragmentShopperCart());

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }


}