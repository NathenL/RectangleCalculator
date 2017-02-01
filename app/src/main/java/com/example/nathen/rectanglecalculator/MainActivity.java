package com.example.nathen.rectanglecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DecimalFormat numberFormat = new DecimalFormat("0.00");
        final EditText widthIn = (EditText)findViewById(R.id.widthInput);
        final EditText lengthIn = (EditText)findViewById(R.id.lengthInput);
        final TextView area = (TextView)findViewById(R.id.outputArea);
        final TextView permimeter = (TextView)findViewById(R.id.outputPermimeter);

        TextWatcher watcher= new TextWatcher() {
            public void afterTextChanged(Editable s) {
                double width = 0.0;
                double length = 0.0;
                if (widthIn.getText().toString().equals("") || widthIn.getText().toString().equals(".")) {
                    width = 0;
                }
                else {
                    width = Double.parseDouble(widthIn.getText().toString());
                }
                if (lengthIn.getText().toString().equals("") || lengthIn.getText().toString().equals(".")) {
                    length = 0;
                }
                else {
                    length = Double.parseDouble(lengthIn.getText().toString());
                }

                area.setText(numberFormat.format(calcArea(width,length)));
                permimeter.setText(numberFormat.format(calcPerimeter(width,length)));
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Do nothing
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Do nothing
            }
        };

        widthIn.addTextChangedListener(watcher);
        lengthIn.addTextChangedListener(watcher);
    }

    /**
     * Calculates the Area of a rectangle
     * @param w Width
     * @param l Length
     * @return double
     */
    private double calcArea(double w,double l){
        return w*l;
    }

    /**
     * Calculates the Permimeter of a rectangle
     * @param w
     * @param l
     * @return
     */
    private double calcPerimeter(double w,double l){
        return (2*w)+(2*l);
    }
}
