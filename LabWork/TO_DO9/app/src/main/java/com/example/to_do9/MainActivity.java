package com.example.to_do9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    private Calculator mCalculator;

    private EditText medittext1, medittext2;

    private TextView mtextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();

        medittext1 = (EditText) findViewById(R.id.operand1);
        medittext2 = (EditText) findViewById(R.id.operand2);
        mtextview = (TextView) findViewById(R.id.result);
    }

    public void addition(View view) { compute(Calculator.Operator.ADD); }

    public void subtraction(View view) { compute(Calculator.Operator.SUB); }

    public void multiplication(View view) { compute(Calculator.Operator.MUL); }

    public void division(View view) { compute(Calculator.Operator.DIV); }

    public void compute( Calculator.Operator operator){
        String operand1 = medittext1.getText().toString();
        String operand2 = medittext2.getText().toString();
        String result = " ";

        switch(operator)
        {
            case ADD:
                result = String.valueOf(mCalculator.add(Double.valueOf(operand1), Double.valueOf(operand2)));
                break;

            case SUB:
                result = String.valueOf(mCalculator.sub(Double.valueOf(operand1), Double.valueOf(operand2)));
                break;

            case MUL:
                result = String.valueOf(mCalculator.mul(Double.valueOf(operand1), Double.valueOf(operand2)));
                break;

            case DIV:
                result = String.valueOf(mCalculator.div(Double.valueOf(operand1), Double.valueOf(operand2)));
                break;

            default:
                Log.d("Calculator","ERROR MESSAGE");
                break;
        }
        mtextview.setText(result);
    }
}