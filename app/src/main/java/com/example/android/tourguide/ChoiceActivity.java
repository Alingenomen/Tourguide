package com.example.android.tourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/** This activity holds the 4 fragments from which the user can browse
 *  through the locations in the Tour guide app
 */

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }
}
