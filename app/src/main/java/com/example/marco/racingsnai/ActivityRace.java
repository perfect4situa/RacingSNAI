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

        String name = dataNames.getString("name");

        pB1 = findViewById(R.id.progressBar1);
        pB2 = findViewById(R.id.progressBar2);
        pB3 = findViewById(R.id.progressBar3);

        btnStart = findViewById(R.id.btnStart);
        btnBack = findViewById(R.id.btnBack);
        btnAgain = findViewById(R.id.btnAgain);

        txtVal1 = findViewById(R.id.val1);
        txtVal2 = findViewById(R.id.val2);
        txtVal3 = findViewById(R.id.val3);

        btnPlus1 = findViewById(R.id.btnPlus1);
        btnPlus2 = findViewById(R.id.btnPlus2);
        btnPlus3 = findViewById(R.id.btnPlus3);

        btnMinus1 = findViewById(R.id.btnMinus1);
        btnMinus2 = findViewById(R.id.btnMinus2);
        btnMinus3 = findViewById(R.id.btnMinus3);

        Toast.makeText(getApplicationContext(), "Welcome " + name, Toast.LENGTH_SHORT).show();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityRace.this, ActivityRegister.class);
                startActivity(i);
            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pB1.setProgress(20);
                pB2.setProgress(20);
                pB3.setProgress(20);
            }
        });

        btnPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal1.getText().toString());
                Toast.makeText(getApplicationContext(), "" + val, Toast.LENGTH_SHORT).show();
                val = val + 0.01;
                Toast.makeText(getApplicationContext(), "" + val, Toast.LENGTH_SHORT).show();
                txtVal1.setText(val.toString().substring(0, 4));

            }
        });

        btnPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal2.getText().toString());
                val = val + 0.01;
                txtVal2.setText(val.toString());
            }
        });

        btnPlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal3.getText().toString());
                val = val + 0.01;
                txtVal3.setText(val.toString());
            }
        });

        btnMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal1.getText().toString());

                if((val - 0.01) >= 0) {
                    val = val - 0.01;
                    txtVal1.setText(val.toString());
                }
                else {
                    Toast.makeText(getApplicationContext(), "You can't", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal2.getText().toString());

                if((val - 0.01) >= 0) {
                    val = val - 0.01;
                    txtVal2.setText(val.toString());
                }
                else {
                    Toast.makeText(getApplicationContext(), "You can't", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal3.getText().toString());

                if((val - 0.01) >= 0) {
                    val = val - 0.01;
                    txtVal3.setText(val.toString());
                }
                else {
                    Toast.makeText(getApplicationContext(), "You can't", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
