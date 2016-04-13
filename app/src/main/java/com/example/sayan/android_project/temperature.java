package com.example.sayan.android_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class temperature extends AppCompatActivity {

    Spinner dropDown;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        dropDown = (Spinner) findViewById(R.id.dropDown);
        adapter = ArrayAdapter.createFromResource(this,R.array.lenght_Unit,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);
        EditText lengthV = (EditText) findViewById(R.id.lengthValue);
        String length = lengthV.getText().toString();

    }
}
