package com.example.marco.racingsnai;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.service.autofill.FillResponse;
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

    String name;
    TextView txtInfo;
    int flagWin;
    String res;

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

        name = dataNames.getString("name");

        txtInfo = findViewById(R.id.txtInfo);

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
                Log.i("FUNZIOna", "prima del THREAD");
                final Thread progress = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int ran1;
                        int ran2;
                        int ran3;
                        flagWin = -1;

                        btnAgain.setClickable(false);

                        btnPlus1.setClickable(false);
                        btnPlus2.setClickable(false);
                        btnPlus3.setClickable(false);

                        btnMinus1.setClickable(false);
                        btnMinus2.setClickable(false);
                        btnMinus3.setClickable(false);
                        Log.i("FUNZIOna", "prima del while");
                        while ((pB1.getProgress() < 1000) || (pB2.getProgress() < 1000) || (pB3.getProgress() < 1000)) {
                            ran1 = (int) ((Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10));
                            ran2 = (int) ((Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10));
                            ran3 = (int) ((Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10));

                            Log.i("FLAG", "" + flagWin);
                            if(flagWin < 0) {
                                if((pB1.getProgress() + ran1) >= 1000) {
                                    flagWin = 0;
                                    Log.i("PASS", "" + flagWin);
                                }
                                else {
                                    if((pB2.getProgress() + ran1) >= 1000) {
                                        flagWin = 1;
                                        Log.i("PASS", "" + flagWin);
                                    }
                                    else {
                                        if((pB3.getProgress() + ran1) >= 1000) {
                                            flagWin = 2;
                                            Log.i("PASS", "" + flagWin);
                                        }
                                    }
                                }
                            }

                            pB1.setProgress(pB1.getProgress() + ran1);
                            pB2.setProgress(pB2.getProgress() + ran2);
                            pB3.setProgress(pB3.getProgress() + ran3);

                            try {
                                Thread.sleep(150);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        btnAgain.setClickable(true);

                        btnPlus1.setClickable(true);
                        btnPlus2.setClickable(true);
                        btnPlus3.setClickable(true);

                        btnMinus1.setClickable(true);
                        btnMinus2.setClickable(true);
                        btnMinus3.setClickable(true);
                    }
                });

                progress.start();

                /*Thread winner = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String ris[] = new String[]{
                                getResources().getString(R.string.too_much_security),
                                getResources().getString(R.string.human_hate),
                                getResources().getString(R.string.industry_4_0)
                        };

                        res = name + ", " + ris[flagWin] + " win the race";
                    }
                });
                Log.i("FINEE", "risultato " + res);*/
                String ris[] = new String[]{
                        getResources().getString(R.string.too_much_security),
                        getResources().getString(R.string.human_hate),
                        getResources().getString(R.string.industry_4_0)
                };

                res = name + ", " + ris[flagWin] + " win the race";
                AlertDialog.Builder alert = new AlertDialog.Builder(ActivityRace.this);
                alert.setTitle("LA TUA VINCITA");
                alert.setMessage(res);
                //AlertDialog msg = alert.create();
                alert.show();
                //txtInfo.setText(res);
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
                pB1.setProgress(0);
                pB2.setProgress(0);
                pB3.setProgress(0);

                txtVal1.setText("0.0");
                txtVal2.setText("0.0");
                txtVal3.setText("0.0");
            }
        });

        btnPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal1.getText().toString());
                val = Math.round((val + 0.1)*10.0)/10.0;
                txtVal1.setText(val.toString());

            }
        });

        btnPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal2.getText().toString());
                val = Math.round((val + 0.1)*10.0)/10.0;
                txtVal2.setText(val.toString());
            }
        });

        btnPlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal3.getText().toString());
                val = Math.round((val + 0.1)*10.0)/10.0;
                txtVal3.setText(val.toString());
            }
        });

        btnMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal1.getText().toString());

                if((val - 0.1) >= 0) {
                    val = Math.round((val - 0.1)*10.0)/10.0;
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

                if((val - 0.1) >= 0) {
                    val = Math.round((val - 0.1)*10.0)/10.0;
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

                if((val - 0.1) >= 0) {
                    val = Math.round((val - 0.1)*10.0)/10.0;
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
