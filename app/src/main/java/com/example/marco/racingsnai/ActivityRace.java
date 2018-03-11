package com.example.marco.racingsnai;

import android.content.DialogInterface;
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

    protected String name;
    protected TextView txtVwInfo;

    protected ProgressBar pB1;
    protected ProgressBar pB2;
    protected ProgressBar pB3;

    protected TextView numVal1;
    protected TextView numVal2;
    protected TextView numVal3;

    protected Button btnStart;
    protected Button btnBack;
    protected Button btnAgain;

    protected Button btnPlus1;
    protected Button btnPlus2;
    protected Button btnPlus3;

    protected Button btnMinus1;
    protected Button btnMinus2;
    protected Button btnMinus3;

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

        Toast.makeText(getApplicationContext(), getString(R.string.welcome) + " " + name, Toast.LENGTH_SHORT).show();

        assignVariables();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BackgroundTask().execute();
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
                resetRace();
            }
        });

        btnPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseDecimal(numVal1);
            }
        });

        btnPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseDecimal(numVal2);
            }
        });

        btnPlus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseDecimal(numVal3);
            }
        });

        btnMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceDecimal(numVal1);
            }
        });

        btnMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceDecimal(numVal2);
            }
        });

        btnMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceDecimal(numVal3);
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

    private void assignVariables() {
        txtVwInfo = findViewById(R.id.txtVwInfo);

        pB1 = findViewById(R.id.progressBar1);
        pB2 = findViewById(R.id.progressBar2);
        pB3 = findViewById(R.id.progressBar3);

        btnStart = findViewById(R.id.btnStart);
        btnBack = findViewById(R.id.btnBack);
        btnAgain = findViewById(R.id.btnAgain);

        numVal1 = findViewById(R.id.val1);
        numVal2 = findViewById(R.id.val2);
        numVal3 = findViewById(R.id.val3);

        btnPlus1 = findViewById(R.id.btnPlus1);
        btnPlus2 = findViewById(R.id.btnPlus2);
        btnPlus3 = findViewById(R.id.btnPlus3);

        btnMinus1 = findViewById(R.id.btnMinus1);
        btnMinus2 = findViewById(R.id.btnMinus2);
        btnMinus3 = findViewById(R.id.btnMinus3);
    }

    private void increaseDecimal(TextView numVal) {
        Double val = Double.parseDouble(numVal.getText().toString());

        if(Math.round((val + 0.1)*10.0)/10.0 < 10) {
            val = Math.round((val + 0.1)*10.0)/10.0;
            numVal.setText(String.valueOf(val));
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.not_allowed, Toast.LENGTH_SHORT).show();
        }
    }

    private void reduceDecimal(TextView numVal) {
        Double val = Double.parseDouble(numVal.getText().toString());

        if(Math.round((val - 0.1)*10.0)/10.0 >= 0) {
            val = Math.round((val - 0.1)*10.0)/10.0;
            numVal.setText(String.valueOf(val));
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.not_allowed, Toast.LENGTH_SHORT).show();
        }
    }

    private void resetRace() {
        txtVwInfo.setText(R.string.info_game);

        pB1.setProgress(0);
        pB2.setProgress(0);
        pB3.setProgress(0);

        numVal1.setText("0.0");
        numVal2.setText("0.0");
        numVal3.setText("0.0");
    }

    private double gameWin(Integer[] flagWin) {
        Double val1 = Double.parseDouble(numVal1.getText().toString());
        Double val2 = Double.parseDouble(numVal2.getText().toString());
        Double val3 = Double.parseDouble(numVal3.getText().toString());

        for(int i = 0; i < flagWin.length; i++) {
            switch(i) {
                case 0:
                    switch(flagWin[i]) {
                        case 0:
                            val1 *= 3;
                            break;
                        case 1:
                            val2 *= 3;
                            break;
                        case 2:
                            val3 *= 3;
                            break;
                    }
                    break;
                case 1:
                    switch(flagWin[i]) {
                        case 0:
                            val1 *= 1.5;
                            break;
                        case 1:
                            val2 *= 1.5;
                            break;
                        case 2:
                            val3 *= 1.5;
                            break;
                    }
                    break;
                case 2:
                    switch(flagWin[i]) {
                        case 0:
                            val1 *= 0;
                            break;
                        case 1:
                            val2 *= 0;
                            break;
                        case 2:
                            val3 *= 0;
                            break;
                    }
                    break;
            }
        }

        return val1 + val2 + val3;
    }

    private class BackgroundTask extends AsyncTask<Void, Integer, Integer[]> {

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
        protected Integer[] doInBackground(Void... voids) {
            int ran1;
            int ran2;
            int ran3;
            int count = 0;
            Integer flagWin[] = new Integer[] {-1, -1, -1};

            while ((pB1.getProgress() < 1000) || (pB2.getProgress() < 1000) || (pB3.getProgress() < 1000)) {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ran1 = (int) ((Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10));
                ran2 = (int) ((Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10));
                ran3 = (int) ((Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10) + (Math.random() * 10));
                //aggiustare assegnazione flag
                if(count < flagWin.length) {
                    if((pB1.getProgress() + ran1) >= 1000) {
                        flagWin[0] = 0;
                        count++;
                    }
                    else {
                        if((pB2.getProgress() + ran2) >= 1000) {
                            flagWin[count] = 1;
                            count++;
                        }
                        else {
                            if((pB3.getProgress() + ran3) >= 1000) {
                                flagWin[count] = 2;
                                count++;
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
        protected void onPostExecute(final Integer... flagWin) {
            super.onPostExecute(flagWin);

            String ris[] = new String[]{
                    getString(R.string.too_much_security),
                    getString(R.string.industry_4_0),
                    getString(R.string.human_hate)
            };

            String res = name + ", " + ris[flagWin[0]] + " " + getString(R.string.str_win);

            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityRace.this);
            builder.setTitle(R.string.msg_winner);
            builder.setMessage("1° " + ris[flagWin[0]] + ", 2° " + ris[flagWin[1]] + ", 3° " + ris[flagWin[1]]);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.got_it, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityRace.this);
                    builder.setTitle(R.string.msg_win);
                    builder.setMessage(gameWin(flagWin) + " $");
                    builder.setCancelable(false);
                    builder.setPositiveButton(R.string.got_it, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            resetRace();
                        }
                    });
                    builder.create().show();
                }
            });
            builder.create().show();

            txtVwInfo.setText(res);

            btnAgain.setClickable(true);
            btnPlus1.setClickable(true);
            btnPlus2.setClickable(true);
            btnPlus3.setClickable(true);
            btnMinus1.setClickable(true);
            btnMinus2.setClickable(true);
            btnMinus3.setClickable(true);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            resetRace();
        }
    }

}
