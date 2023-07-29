package com.example.b07project;

public class Item {
    long id;
    String name;
    double price;
    String description;

    // constructors, setters, getters, equals (based on id), hashcode (equal to id)
    public boolean addItem(String owner_username) {
        // add item to database, create unique id for it
        // ret value determine success (T) or fail (F)
        return false;
    }
    public boolean removeItem(String owner_username) {
        // look for equal item to this (why we override equals)
        // remove from database (under Owners, products)
        // ret value for success (T) or fail (F)
        return false;
    }
}
