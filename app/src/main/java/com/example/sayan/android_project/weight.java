package com.example.sayan.android_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class weight extends AppCompatActivity {

    Spinner dropDown;               //Spinner Deceleration
    ArrayAdapter adapter;          //Array Adapter Deceleration
    String selectedUnit;           //SelectedUnit Deceleration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        dropDown = (Spinner) findViewById(R.id.dropDown);
        adapter = ArrayAdapter.createFromResource(this,R.array.weight_Unit,android.R.layout.simple_spinner_item);
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
        String g = "g" ;
        String k = "Kg" ;
        String l = "lb" ;
        //Storing the user input
        EditText weightV = (EditText) findViewById(R.id.weightValue);
        String weightValueString = weightV.getText().toString();
        if(TextUtils.isEmpty(weightValueString))
        {
            Toast.makeText(this, "Please Enter A Value", Toast.LENGTH_SHORT).show();
        }
        else
        {
            double value = Double.parseDouble(weightValueString);
            //comparing the strings

            if (selectedUnit.equals(g)) {
                displayResult(value, value / 1000, (value / 1000) * 2.204622622);
            }
            if (selectedUnit.equals(k)) {
                displayResult(value * 1000, value, value * 2.204622622);
            }
            if (selectedUnit.equals(l)) {
                displayResult((value / 2.204622622) * 1000, value / 2.204622622, value);
            }

        }


    }
    //To display the output
    private void displayResult(double g,double kg,double lb)
    {
        TextView gmResultTextView = (TextView) findViewById(R.id.gm);
        gmResultTextView.setText("" + g);
        TextView kgResultTextView = (TextView) findViewById(R.id.kg);
        kgResultTextView.setText("" + kg);
        TextView lbResultTextView = (TextView) findViewById(R.id.lb);
        lbResultTextView.setText("" + lb);
    }
}
