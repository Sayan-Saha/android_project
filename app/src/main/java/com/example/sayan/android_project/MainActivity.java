package com.example.sayan.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void length(View view)
    {
        Intent next = new Intent(this,lengthActivity.class);
        startActivity(next);
    }
    public void temp(View view)
    {
        Intent next = new Intent(this,temperature.class);
        startActivity(next);
    }
    public void weight(View view)
    {
        Intent next = new Intent(this,weight.class);
        startActivity(next);
    }
}
