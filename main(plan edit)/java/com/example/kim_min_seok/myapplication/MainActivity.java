package com.example.kim_min_seok.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerHourS =(Spinner)findViewById(R.id.HourStart);

        ArrayAdapter adapterHour = ArrayAdapter.createFromResource(
                this,R.array.Hour,android.R.layout.simple_spinner_item);

        spinnerHourS.setAdapter(adapterHour);

        Spinner spinnerMinS =(Spinner)findViewById(R.id.MinStart);

        ArrayAdapter adapterMin = ArrayAdapter.createFromResource(
                this,R.array.Min,android.R.layout.simple_spinner_item);

        spinnerMinS.setAdapter(adapterMin);

        Spinner spinnerHourE =(Spinner)findViewById(R.id.HourEnd);

        ArrayAdapter adapterHourE = ArrayAdapter.createFromResource(
                this,R.array.Hour,android.R.layout.simple_spinner_item);

        spinnerHourE.setAdapter(adapterHourE);

        Spinner spinnerMinE =(Spinner)findViewById(R.id.MinEnd);

        ArrayAdapter adapterMinE = ArrayAdapter.createFromResource(
                this,R.array.Min,android.R.layout.simple_spinner_item);

        spinnerMinE.setAdapter(adapterMinE);

        button = (Button) findViewById(R.id.PlanType);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PopupActivity.class));
            }


    });




}
}
