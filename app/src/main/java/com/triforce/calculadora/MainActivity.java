package com.triforce.calculadora;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView prop10txt, prop15txt, prop20txt, txtvtotal10, txtvtotal15, txtvtotal20;
    private EditText editTextNumber;
    private String texto;
    private float diez, quince, veinte;
    private float dinero;
    private SeekBar porcentaje;
    private TextView propinaSB, totalSB, porcentajeSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        prop10txt = findViewById(R.id.txtvprop10);
        prop15txt = findViewById(R.id.txtvprop15);
        prop20txt = findViewById(R.id.txtvprop20);

        porcentaje = findViewById(R.id.seekBar);

        txtvtotal10 = findViewById(R.id.txtvtotal10);
        txtvtotal15 = findViewById(R.id.txtvtotal15);
        txtvtotal20 = findViewById(R.id.txtvtotal20);

        propinaSB = findViewById(R.id.txtvpropinaSB);
        totalSB = findViewById(R.id.txtvtotalSB);
        porcentajeSB = findViewById(R.id.textView9);

        porcentajeSB.setText("%0");

        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                texto = s.toString();
                if (!texto.isEmpty()) {
                    dinero = Float.parseFloat(texto);
                }

                diez = (float) (dinero*0.1);
                quince = (float) (dinero*0.15);
                veinte = (float) (dinero*0.2);

                prop10txt.setText(String.format("%.2f",diez));
                prop15txt.setText(String.format("%.2f",quince));
                prop20txt.setText(String.format("%.2f",veinte));

                txtvtotal10.setText(String.format("%.2f",dinero + diez));
                txtvtotal15.setText(String.format("%.2f",dinero + quince));
                txtvtotal20.setText(String.format("%.2f",dinero + veinte));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        porcentaje.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentajeSB.setText("%" + i);
                String aux = editTextNumber.getText().toString();

                float aux2 = 0;
                float aux3 = 0;
                if (!aux.isEmpty()) {
                    try {
                        aux2 = Float.parseFloat(aux);
                        aux3 = aux2 * (i / 100f);
                        propinaSB.setText(String.format("%.2f", aux3));
                        float aux4 = aux2 + aux3;
                        totalSB.setText(String.format("%.2f",aux4));
                    } catch (NumberFormatException e) {
                        propinaSB.setText("Error");
                    }
                } else {
                    propinaSB.setText("");
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }







}