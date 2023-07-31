package com.example.b07project;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.io.*;

public class ShopperItem {
    private String id;
    private int quantity;
    private int status; // 0 for not yet ordered (i.e. in cart), 1 for ordered but not read, 2 for ready
    Button btn;

    static private DatabaseReference ref = FirebaseDatabase.getInstance("https://b07-project-3237a-default-rtdb.firebaseio.com/").getReference("Shoppers");

    // constructor, setters, getters, equals, hashcode
    // getters

    public ShopperItem() {
    }

    public ShopperItem(int quantity, String id) {
        this.quantity = quantity;
        this.id = id;
        this.status = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean removeFromCart(int quantity, String username) {
        // only works if status is 0
        // reduce this.quantity by quantity
        // if 0 or neg, remove this object from database (from under Shoppers and Cart)
        return false;
    }

    public void addToCart(String id, int quantity, String username, String ownerUsername) {
        // add item associated with id to database if not already there
        // if already there, increase quantity of item

        ref = FirebaseDatabase.getInstance().getReference("Shoppers");
        DatabaseReference cart_ref = ref.child(username).child("cart");

        ref.child(username).child("cart").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // item exists
                if (snapshot.exists()) {
                    Integer currentQuantity = snapshot.child("quantity").getValue(Integer.class);
                    int newQuantity = (int) currentQuantity + quantity;
                    ref.child(username).child("cart").child(id).child("quantity").setValue(newQuantity);

                } else {
                    ShopperItem shopperItem = new ShopperItem(quantity, id);
                    ref.child(username).child("cart").child(id).setValue(shopperItem);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(btn.getContext(), "Failed to add to cart " + error, Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}