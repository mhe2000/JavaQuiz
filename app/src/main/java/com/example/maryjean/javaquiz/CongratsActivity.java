package com.example.maryjean.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author      Maryjean Emerson <maryjean_emerson@hotmail.com>
 * @version     1.18               (current version number of program)
 *
 *Create a new Activity that appears when all the questions are answered correctly
 *
 */

public class CongratsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
    }
}
