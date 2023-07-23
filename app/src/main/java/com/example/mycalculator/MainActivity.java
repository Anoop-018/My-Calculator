package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);

        addButton.setOnClickListener(v -> calculate('+'));

        subtractButton.setOnClickListener(v -> calculate('-'));

        multiplyButton.setOnClickListener(v -> calculate('*'));

        divideButton.setOnClickListener(v -> calculate('/'));
    }

    @SuppressLint("SetTextI18n")
    private void calculate(char operation) {
        double num1 = Double.parseDouble(number1EditText.getText().toString());
        double num2 = Double.parseDouble(number2EditText.getText().toString());
        double result = 0.0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultTextView.setText("Error: Cannot divide by zero.");
                    return;
                }
                break;
        }

        resultTextView.setText("Result: " + result);
    }
}