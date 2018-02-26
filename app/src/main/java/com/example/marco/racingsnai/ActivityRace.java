package com.example.marco.racingsnai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActivityRace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        Log.i("Activity status", "onCreate()");

        Bundle dataNames = getIntent().getExtras();

        String name1 = dataNames.getString("name1");
        String name2 = dataNames.getString("name2");
        String name3 = dataNames.getString("name3");

        Toast.makeText(getApplicationContext(), name1 + " - " + name2 + " - " + name3, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("Activity status", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Activity status", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("Activity status", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("Activity status", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("Activity status", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("Activity status", "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i("Activity status", "onSaveInstanceState()");

        outState.putString("", "");
    }

}
