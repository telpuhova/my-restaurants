package com.epicodus.myrestaurants;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
//    private Button mFindRestaurantsButton;
//    private EditText mLocationEditText;
//    private TextView mAppNameTextView;

    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
//        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                Log.d(TAG, location);
//                Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
                //a new Intent that takes the user from the MainActivity to the RestaurantsActivity will be created and immediately started.
            }
        });
    }
}
