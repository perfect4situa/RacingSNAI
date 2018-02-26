package com.example.marco.racingsnai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityRegister extends AppCompatActivity {

    Button btnGoToRace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnGoToRace.findViewById(R.id.btnGoToRace);
        btnGoToRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityRegister.this, ActivityRace.class);

                EditText nm1 = findViewById(R.id.insName1);
                EditText nm2 = findViewById(R.id.insName2);
                EditText nm3 = findViewById(R.id.insName3);

                i.putExtra("name1", nm1.getText().toString());
                i.putExtra("name2", nm2.getText().toString());
                i.putExtra("name3", nm3.getText().toString());

                startActivity(i);
            }
        });
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
