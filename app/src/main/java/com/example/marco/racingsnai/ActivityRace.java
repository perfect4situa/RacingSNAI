package com.example.marco.racingsnai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ActivityRace extends AppCompatActivity {

    ProgressBar pB1;
    ProgressBar pB2;
    ProgressBar pB3;

    TextView txtNm1;
    TextView txtNm2;
    TextView txtNm3;

    TextView txtVal1;
    TextView txtVal2;
    TextView txtVal3;

    Button btnStart;
    Button btnBack;
    Button btnAgain;

    Button btnPlus1;
    Button btnPlus2;
    Button btnPlus3;

    Button btnMinus1;
    Button btnMinus2;
    Button btnMinus3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        Log.i("Activity status", "onCreate()");

        Bundle dataNames = getIntent().getExtras();

        pB1 = findViewById(R.id.progressBar1);
        pB2 = findViewById(R.id.progressBar2);
        pB3 = findViewById(R.id.progressBar3);

        btnStart = findViewById(R.id.btnStart);
        btnBack = findViewById(R.id.btnBack);
        btnAgain = findViewById(R.id.btnAgain);

        txtNm1 = findViewById(R.id.txtNm1);
        txtNm2 = findViewById(R.id.txtNm2);
        txtNm3 = findViewById(R.id.txtNm3);

        txtVal1 = findViewById(R.id.val1);
        txtVal2 = findViewById(R.id.val2);
        txtVal3 = findViewById(R.id.val3);

        btnPlus1 = findViewById(R.id.btnPlus1);
        btnPlus2 = findViewById(R.id.btnPlus2);
        btnPlus3 = findViewById(R.id.btnPlus3);

        btnMinus1 = findViewById(R.id.btnMinus1);
        btnMinus2 = findViewById(R.id.btnMinus2);
        btnMinus3 = findViewById(R.id.btnMinus3);

        String name1 = dataNames.getString("name1");
        String name2 = dataNames.getString("name2");
        String name3 = dataNames.getString("name3");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityRace.this, ActivityRegister.class);
                startActivity(i);
            }
        });

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
