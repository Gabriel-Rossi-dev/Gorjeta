package com.cursoandroid.teste.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textP, textTip, textTotal;
    private EditText textInput;
    private SeekBar seekBar;

    private double porcentage = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.textInput);
        textP = findViewById(R.id.textP);
        textTip = findViewById(R.id.textTip);
        textTotal = findViewById(R.id.textTotal);
        seekBar = findViewById(R.id.seekBar);




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                porcentage = i;
                textP.setText(Math.round(porcentage) + "%");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calculate(){

        String recoveryValue = textInput.getText().toString();
        if (recoveryValue == null || recoveryValue.equals("") ){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();

        }else {

            double valueDig = Double.parseDouble(recoveryValue);
            double tip = valueDig * (porcentage /100);


            textTip.setText("R$ " + tip);
            textTotal.setText("R$ " + (tip + valueDig));



        }

    }



}
