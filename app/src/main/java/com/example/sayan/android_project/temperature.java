package com.example.sayan.android_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class temperature extends AppCompatActivity {

    Spinner dropDown;               //Spinner Deceleration
    ArrayAdapter adapter;          //Array Adapter Deceleration
    String selectedUnit;           //SelectedUnit Deceleration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        dropDown = (Spinner) findViewById(R.id.dropDown);
        adapter = ArrayAdapter.createFromResource(this,R.array.temperature_Unit,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedUnit = parent.getItemAtPosition(position).toString();  //what will bE performed when selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //what will bE performed when nothing selected
            }
        });
    }
    public void convert (View view)
    {
        //Initialization of units to compare with spinner values
        String c = "\u00B0C" ;
        String f = "\u00B0F" ;
        String k = "K" ;
        //Storing the user input
        EditText tempV = (EditText) findViewById(R.id.temperatureValue);
        String temperatureValueString = tempV.getText().toString();
        if(TextUtils.isEmpty(temperatureValueString))
        {
            Toast.makeText(this, "Please Enter A Value", Toast.LENGTH_SHORT).show();
        }
        else
        {
            double value = Double.parseDouble(temperatureValueString);
            //comparing the strings


            if (selectedUnit.equals(c)) {
                displayResult(value, (value * 1.8) + 32, value + 273.15);
            }

            if (selectedUnit.equals(f)) {
                displayResult((value - 32) * 5 / 9, value, ((value - 32) * 5 / 9) + 273.15);
            }
            if (selectedUnit.equals(k)) {
                displayResult(value - 273.15, ((value - 273.15) * 1.8) + 32, value);
            }
        }
    }
    //To display the output
    private void displayResult(double c,double f,double k)
    {
        TextView CResultTextView = (TextView) findViewById(R.id.C);
        CResultTextView.setText("" + c);
        TextView FResultTextView = (TextView) findViewById(R.id.F);
        FResultTextView.setText("" + f);
        TextView KResultTextView = (TextView) findViewById(R.id.K);
        KResultTextView.setText("" + k);
    }

}
