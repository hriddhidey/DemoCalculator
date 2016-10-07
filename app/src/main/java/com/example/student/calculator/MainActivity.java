package com.example.student.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView dispText;
    Button b;
    String current = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dispText = (TextView) findViewById(R.id.displayText);
        dispText.setText("0");
    }

    public void addItem(View view) {
        b = (Button) view;
        String operand = b.getText().toString();
        current += operand;
        dispText.setText(current);
    }

    public void giveOutput(View view) {
        String expression = dispText.getText().toString();
        float x = 0;
        float p = 0, q=0;
        char op = ' ';
        boolean flag = true;
        char a;
        for (int i = 0; i < expression.length(); i++) {
            a = expression.charAt(i);
            switch (a) {
                case '+':
                    op = '+';
                    p = x;
                    x = 0;
                    break;
                case '-':
                    op = '-';
                    p = x;
                    x = 0;
                    break;
                case 'x':
                    op = 'x';
                    p = x;
                    x = 0;
                    break;
                case '/':
                    op = '/';
                    p = x;
                    x = 0;
                    break;
                default:
                    x = (x * 10) + Float.parseFloat(String.valueOf(a));
                    break;
            }
        }
        q = x;
        Log.d(String.valueOf(p),"First number!");
        Log.d(String.valueOf(q),"Second number!");
        switch (op) {
            case '+':
                p += q;
                break;
            case '-':
                p -= q;
                break;
            case 'x':
                p *= q;
                break;
            case '/':
                if (q == 0) {
                    flag = false;
                } else p /= q;
                break;
        }
        if (flag) {
            current = String.valueOf(p);
            dispText.setText(current);
        } else dispText.setText("Illegal calculation!");
        current = "";
    }

    public void clearLast(View view) {
        current = dispText.getText().toString();
        if (current.length() > 0) {
            current = current.substring(0, current.length() - 1);
        }
        dispText.clearComposingText();
        dispText.setText(current);
    }

}

