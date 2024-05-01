package com.example.binary_hex;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private Spinner spinnerConversion;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        spinnerConversion = findViewById(R.id.spinnerConversion);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConversion.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertNumber();
            }
        });
    }

    private void convertNumber() {
        String numberStr = editTextNumber.getText().toString();
        if (numberStr.isEmpty()) {
            textViewResult.setText("Please enter a number");
            return;
        }

        int number = Integer.parseInt(numberStr);

        String conversionType = spinnerConversion.getSelectedItem().toString();

        if (conversionType.equals("Binary")) {
            String binary = Integer.toBinaryString(number);
            textViewResult.setText("Binary: " + binary);
        } else if (conversionType.equals("Hexadecimal")) {
            String hex = Integer.toHexString(number);
            textViewResult.setText("Hexadecimal: " + hex);
        }
    }
}
