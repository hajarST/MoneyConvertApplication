package com.example.moneyconvertapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etAmount;
    private Spinner spUnit;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.et_amount);
        spUnit = findViewById(R.id.sp_unit);
        btnConvert = findViewById(R.id.btn_convert);
        tvResult = findViewById(R.id.tv_result);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = 0.0;
                try {
                    amount = Double.parseDouble(etAmount.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid amount",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                String unit = spUnit.getSelectedItem().toString();
                double convertedAmount1 = 0.0;
                double convertedAmount2 = 0.0;
                String result = "";

                if (unit.equals("MAD")) {
                    convertedAmount1 = amount * 0.091;
                    convertedAmount2 = amount * 0.12;
                    result = String.format("%.2f MAD = %.2f Dollar, %.2f Euro", amount, convertedAmount1, convertedAmount2);
                } else if (unit.equals("Dollar")) {
                    convertedAmount1 = amount * 8.87;
                    convertedAmount2 = amount * 0.85;
                    result = String.format("%.2f Dollar = %.2f MAD, %.2f Euro", amount, convertedAmount1, convertedAmount2);
                } else if (unit.equals("Euro")) {
                    convertedAmount1 = amount * 7.62;
                    convertedAmount2 = amount * 1.17;
                    result = String.format("%.2f Euro = %.2f MAD, %.2f Dollar", amount, convertedAmount1, convertedAmount2);
                }

                tvResult.setText(result);
            }
        });
    }
}