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

        Bundle dataNames = getIntent().getExtras();
        String name1 = dataNames.getString("name1");
        String name2 = dataNames.getString("name2");
        String name3 = dataNames.getString("name3");

        Toast toast = Toast.makeText(getApplicationContext(), name1 + "\n" + name2 + "\n" + name3, Toast.LENGTH_SHORT);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
