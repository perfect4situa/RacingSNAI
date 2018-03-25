package com.example.marco.racingsnai;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {

    TextView title;
    TextView subTitle;
    EditText insName;
    Button btnGoTo;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Log.i("Activity status", "onCreate()");

        title = findViewById(R.id.txtVwUpRegister);
        subTitle = findViewById(R.id.txtVwSubUpRegister);
        insName = findViewById(R.id.insName);
        btnGoTo = findViewById(R.id.btnGoTo);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        user = sharedPreferences.getString("user", "");

        if(!user.isEmpty()) {
            title.setText(String.format("%s, %s", getString(R.string.welcomeBack), user));
            subTitle.setText(String.format("%s %s? %s", getString(R.string.notYou), user, getString(R.string.insert_username)));
            insName.setText(user);
        }

        btnGoTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = insName.getText().toString().replace(" ", "");

                if(user.isEmpty() || user.length() > 10) {
                    Animation shake = AnimationUtils.loadAnimation(ActivityRegister.this, R.anim.shake);
                    btnGoTo.startAnimation(shake);

                    if(user.isEmpty()) {
                        Toast.makeText(getApplicationContext(), R.string.insert_name_toast, Toast.LENGTH_SHORT).show();
                    }
                    if(user.length() > 10) {
                        Toast.makeText(getApplicationContext(), R.string.longUser, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("user", user);
                    editor.apply();

                    Intent i = new Intent(ActivityRegister.this, ActivityRace.class);

                    i.putExtra("name", user);

                    startActivity(i);
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
    public void onBackPressed() {
        new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle(R.string.exit)
            .setMessage(R.string.exitMsg)
            .setPositiveButton(R.string.yesResp, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(startMain);
                }
            })
            .setNegativeButton("No", null).show();
    }

}
