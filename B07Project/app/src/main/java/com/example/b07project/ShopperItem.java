package com.example.b07project;

public class ShopperItem {
    private Item item;
    private int quantity;
    private int status; // 0 for not yet ordered (i.e. in cart), 1 for ordered but not read, 2 for ready

    // constructor, setters, getters, equals, hashcode
    public boolean removeFromCart(int quantity, String username) {
        // only works if status is 0
        // reduce this.quantity by quantity
        // if 0 or neg, remove this object from database (from under Shoppers and Cart)
        return false;
    }

    public boolean addToCart(long id, int quantity, String username) {
        // add item associated with id to database if not already there
        // if already there, increase quantity of item
        return false;
    }
}
