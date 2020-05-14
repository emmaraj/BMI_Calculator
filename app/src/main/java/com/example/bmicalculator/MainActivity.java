package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.String.*;

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

    public void onClickCalculate(View view) {
        String height_measure = spinnerHeight.getSelectedItem().toString().trim();
        String weight_measure = spinnerWeight.getSelectedItem().toString().trim();

        String heightValue = editTextHeight.getText().toString();
        String weightValue = editTextWeight.getText().toString();

        if (heightValue.length() != 0 && weightValue.length() != 0) {
            double height = Double.parseDouble(heightValue);
            double weight = Double.parseDouble(weightValue);

            if (isHeightValid(height) && isWeightValid(weight)) {
                if (height_measure.equals("in")) {
                    height = convertInchesToMeters(height);
                } else {
                    height = convertToMeters(height);
                }
                if (weight_measure.equals("lbs")) {
                    weight = convertToKilogram(weight);
                }
                //convert height into meters

                double BMI = calculateBMI(weight, height);
                textViewBMI.setText(format("%.2f", BMI));
                
            } else if (!isWeightValid(height)) {
                editTextHeight.setError("Kindly enter a valid Height");
            } else {
                editTextWeight.setError("Kindly enter a valid Weight");
            }
        } else if (heightValue.length() == 0) {
            editTextHeight.setError("Kindly enter a value for Height");
        } else {
            editTextWeight.setError("Kindly enter a value for Weight");
        }

    }

    private double convertToMeters(double height) {
        return height / 100;
    }

    /**
     * @param inch Inputted Inch from the user
     * @return int Centimeter equivalent of an inch value
     */

    private double convertInchesToMeters(double inch) {
        return inch / 39.37;
    }

    private double convertToKilogram(double value) {
        return value / 2.205;
    }

    private double calculateBMI(double weight, double height) {
//        DecimalFormat format = new DecimalFormat("##.00");
        double result = weight / Math.pow(height, 2);
        return result;
    }

    private boolean isHeightValid(double height) {
        boolean status = false;

        if (height > 0.5) {
            status = true;
        }

        return status;
    }

    private boolean isWeightValid(double weight) {
        boolean status = false;

        if (weight > 5) {
            status = true;
        }

        return status;
    }

    private String getClassification(double index) {
        String classification = null;
        if (index < 18.5) {
            classification = "Underweight";
        } else if (index >= 18.5 && index <= 24.9) {
            classification = "Normal";
        } else if (index >= 25.0 && index <= 29.9) {
            classification = "Overweight";
        } else if (index >= 30.0 && index <= 34.9) {
            classification = "Obese Class I";
        } else if (index >= 35.0 && index <= 39.9) {
            classification = "Obese Class II";
        } else if (index >= 40.0) {
            classification = "Obese Class III";
        }
        return classification;
    }
}
