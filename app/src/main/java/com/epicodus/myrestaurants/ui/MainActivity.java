package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.myrestaurants.Constants;
import com.epicodus.myrestaurants.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();

//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mSearchedLocationReference;

    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();
            Log.d(TAG, location);

            saveLocationToFirebase(location);

//            if (!(location.equals(""))) {
//                addToSharedPreferences(location);
//            }

            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
            //a new Intent that takes the user from the MainActivity to the RestaurantsActivity will be created and immediately started.
        }
    }

//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }

    private void saveLocationToFirebase(String location) {
        mSearchedLocationReference.push().setValue(location);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedLocationReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindRestaurantsButton.setOnClickListener(this);
    }
}
