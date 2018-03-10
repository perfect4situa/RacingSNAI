package com.example.marco.racingsnai;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityRace extends AppCompatActivity {

    String name;
    TextView txtInfo;

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

        if(dataNames != null) {
            name = dataNames.getString("name");
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.error_name, Toast.LENGTH_SHORT).show();
        }

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
                new BackgoundTask().execute();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                txtVal1.setText(String.valueOf(val));
            }
        });

        btnPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal2.getText().toString());
                val = Math.round((val + 0.1)*10.0)/10.0;
                txtVal2.setText(String.valueOf(val));
            }
        });

        btnPlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal3.getText().toString());
                val = Math.round((val + 0.1)*10.0)/10.0;
                txtVal3.setText(String.valueOf(val));
            }
        });

        btnMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal1.getText().toString());

                if((val - 0.1) >= 0) {
                    val = Math.round((val - 0.1)*10.0)/10.0;
                    txtVal1.setText(String.valueOf(val));
                }
                else {
                    Toast.makeText(getApplicationContext(), R.string.not_allowed, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal2.getText().toString());

                if((val - 0.1) >= 0) {
                    val = Math.round((val - 0.1)*10.0)/10.0;
                    txtVal2.setText(String.valueOf(val));
                }
                else {
                    Toast.makeText(getApplicationContext(), R.string.not_allowed, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val = Double.parseDouble(txtVal3.getText().toString());

                if((val - 0.1) >= 0) {
                    val = Math.round((val - 0.1)*10.0)/10.0;
                    txtVal3.setText(String.valueOf(val));
                }
                else {
                    Toast.makeText(getApplicationContext(), R.string.not_allowed, Toast.LENGTH_SHORT).show();
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

    private class BackgoundTask extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            btnAgain.setClickable(false);
            btnPlus1.setClickable(false);
            btnPlus2.setClickable(false);
            btnPlus3.setClickable(false);
            btnMinus1.setClickable(false);
            btnMinus2.setClickable(false);
            btnMinus3.setClickable(false);
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            int ran1;
            int ran2;
            int ran3;
            int flagWin = -1;

            while ((pB1.getProgress() < 1000) || (pB2.getProgress() < 1000) || (pB3.getProgress() < 1000)) {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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

                publishProgress(ran1, ran2, ran3);
            }

            return flagWin;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            pB1.setProgress(pB1.getProgress() + values[0]);
            pB2.setProgress(pB2.getProgress() + values[1]);
            pB3.setProgress(pB3.getProgress() + values[2]);
        }

        @Override
        protected void onPostExecute(Integer flagWin) {
            super.onPostExecute(flagWin);

            String ris[] = new String[]{
                    getString(R.string.too_much_security),
                    getString(R.string.human_hate),
                    getString(R.string.industry_4_0),
            };

            String res = name + ", " + ris[flagWin] + " win the race";

            AlertDialog.Builder alert = new AlertDialog.Builder(ActivityRace.this);
            alert.setTitle(R.string.msg_win);
            alert.setMessage(res);
            //AlertDialog msg = alert.create();
            alert.show();

            txtInfo.setText(res);

            btnAgain.setClickable(true);
            btnPlus1.setClickable(true);
            btnPlus2.setClickable(true);
            btnPlus3.setClickable(true);
            btnMinus1.setClickable(true);
            btnMinus2.setClickable(true);
            btnMinus3.setClickable(true);
        }

    }

}
