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

public class lengthActivity extends AppCompatActivity {

    Spinner dropDown;                //Spinner Deceleration
    ArrayAdapter adapter;           //Array Adapter Deceleration
    String selectedUnit;           //SelectedUnit Deceleration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        dropDown = (Spinner) findViewById(R.id.dropDown);         //Spinner Initialization
        adapter = ArrayAdapter.createFromResource(this,R.array.lenght_Unit,android.R.layout.simple_spinner_item);  //Array Adapter Initialization
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
        String k = "km" ;
        String m = "m" ;
        String c = "cm" ;
        //Storing the user input
        EditText lengthV = (EditText) findViewById(R.id.lengthValue);
        String lengthValueString = lengthV.getText().toString();
        if(TextUtils.isEmpty(lengthValueString))
        {
            Toast.makeText(this, "Please Enter A Value", Toast.LENGTH_SHORT).show();
        }
        else
        {
            double value = Double.parseDouble(lengthV.getText().toString());
            //comparing the strings

            if (selectedUnit.equals(k)) {
                displayResult(value , (value * 1000), value * 100000);
            }
            if (selectedUnit.equals(m)) {
                displayResult(value / 1000, value, value * 100);
            }
            if (selectedUnit.equals(c)) {
                displayResult(value / 100000, value / 100, value);
            }
        }
    }
    //To display the output
    private void displayResult(double km,double m,double cm)
    {
        TextView kmResultTextView = (TextView) findViewById(R.id.km);
        kmResultTextView.setText("" + km);
        TextView mResultTextView = (TextView) findViewById(R.id.m);
        mResultTextView.setText("" + m);
        TextView cmResultTextView = (TextView) findViewById(R.id.cm);
        cmResultTextView.setText("" + cm);
    }

}
