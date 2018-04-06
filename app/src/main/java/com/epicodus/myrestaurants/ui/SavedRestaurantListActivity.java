package com.epicodus.myrestaurants.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.epicodus.myrestaurants.R;
import com.google.firebase.database.DatabaseReference;

public class SavedRestaurantListActivity extends AppCompatActivity {
    private DatabaseReference mRestaurantReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_restaurant_list);

    }




}