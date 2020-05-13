package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerHeight, spinnerWeight;
    private EditText editTextHeight, editTextWeight;
    private TextView textViewBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerHeight = findViewById(R.id.spinnerHeight);
        spinnerWeight = findViewById(R.id.spinnerWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        textViewBMI = findViewById(R.id.textViewBMI);
    }

    public void onClickCalculate(View view){
        String height_measure = spinnerHeight.getSelectedItem().toString().trim();
        String weight_measure = spinnerWeight.getSelectedItem().toString().trim();

        String heightValue = editTextHeight.getText().toString();
        String weightValue = editTextWeight.getText().toString();

        if (heightValue.length() != 0 && weightValue.length() != 0) {
            double height = Double.parseDouble(heightValue);
            double weight = Double.parseDouble(weightValue);

            if (isHeightValid(height) && isWeightValid(weight)){
                if (height_measure.equals("in")) {
                    height = convertToCentimeter(height);
                }
                if (weight_measure.equals("lbs")) {
                    weight = convertToKilogram(weight);
                }
                textViewBMI.setText(String.valueOf(calculateBMI(weight, height)));
            } else if (!isWeightValid(height)){
                editTextHeight.setError("Kindly enter a valid Height");
            } else {
                editTextWeight.setError("Kindly enter a valid Weight");
            }
        } else if (heightValue.length() == 0) {
            editTextHeight.setError("Kindly enter a value for Height");
        } else{
            editTextWeight.setError("Kindly enter a value for Weight");
        }

    }

    /**
     *
     * @param inch Inputted Inch from the user
     * @return int Centimeter equivalent of an inch value
     */

    private double convertToCentimeter(double inch){
        return inch / 2.54;
    }

    private double convertToKilogram(double value){
        return value / 2.205;
    }

    private double calculateBMI(double weight, double height) {
        return (weight / Math.pow(height, 2));
    }

    private boolean isHeightValid(double height){
        boolean status = false;

        if (height > 0.5){
            status = true;
        }

        return status;
    }

    private boolean isWeightValid(double weight){
        boolean status = false;

        if (weight > 5){
            status = true;
        }

        return status;
    }
}
