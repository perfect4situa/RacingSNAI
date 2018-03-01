package com.example.marco.racingsnai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {

    EditText insName;
    Button btnGoTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Log.i("Activity status", "onCreate()");

        insName = findViewById(R.id.insName);
        btnGoTo = findViewById(R.id.btnGoTo);

        btnGoTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = insName.getText().toString().replace(" ", "");

                if(user.isEmpty()) {
                    Animation shake = AnimationUtils.loadAnimation(ActivityRegister.this, R.anim.shake);
                    btnGoTo.startAnimation(shake);

                    Toast.makeText(getApplicationContext(), R.string.insert_name_toast, Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(ActivityRegister.this, ActivityRace.class);

                    i.putExtra("name", user);

                    startActivity(i);
                }
            }
        });

        /*ins2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ins1.getText().toString().replace(" ", "").isEmpty()) {
                    Animation shake = AnimationUtils.loadAnimation(ActivityRegister.this, R.anim.shake);
                    ins2.startAnimation(shake);

                    Toast.makeText(getApplicationContext(), R.string.insert_name_toast, Toast.LENGTH_SHORT).show();
                }
                else {
                    ins2.setVisibility(View.VISIBLE);
                }
            }
        });

        ins3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ins1.getText().toString().replace(" ", "").isEmpty() || ins2.getText().toString().replace(" ", "").isEmpty()) {
                    Animation shake = AnimationUtils.loadAnimation(ActivityRegister.this, R.anim.shake);
                    ins3.startAnimation(shake);

                    Toast.makeText(getApplicationContext(), R.string.insert_name_toast, Toast.LENGTH_SHORT).show();
                }
                else {
                    ins2.setVisibility(View.VISIBLE);
                }
            }
        });*/
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
