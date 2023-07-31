package com.example.b07project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class FragmentShopperCart extends Fragment {

    String username;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        username = this.getArguments().getString("username");
        View view = inflater.inflate(R.layout.fragment_shopper_cart, container, false);

        System.out.println("1");
        btn = view.findViewById(R.id.button3);

        String username = "alysa";
        String id = "Na_Eijs3x7h4EMlhSr3p";
        String ownerUsername = "a";

        ShopperItem item = new ShopperItem();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               item.addToCart(id, 3, username, ownerUsername);
                Log.d("abc", String.valueOf(item.addSuccessful));
            }
        });

        return view;
    }
}