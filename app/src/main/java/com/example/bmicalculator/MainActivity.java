package com.example.bmicalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI(View view) {
        Intent intent = new Intent();
        EditText height = (EditText) findViewById(R.id.heightInput);
        EditText weight = (EditText) findViewById(R.id.weightInput);
        Double heightValue = Double.parseDouble(height.getText().toString()) / 100;
        Double weightValue = Double.parseDouble(weight.getText().toString());
        Double result = (weightValue) / (heightValue * heightValue);
        String resultString = String.format("%.2f", result);

        TextView resultOutput = findViewById(R.id.resultField);
        resultOutput.setText(resultString);

        closeKeyboard();
    }

    public void resetInputs(View view) {
        EditText height = (EditText) findViewById(R.id.heightInput);
        EditText weight = (EditText) findViewById(R.id.weightInput);
        TextView resultOutput = findViewById(R.id.resultField);
        height.setText("");
        weight.setText("");
        resultOutput.setText("");
        height.requestFocus();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if(view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
