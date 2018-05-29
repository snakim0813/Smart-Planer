package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Week_Activity_TypeB extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_week_b_type);

       Spinner spinnerType =(Spinner)findViewById(R.id.TypeSelectionB);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,R.array.Week_TypeB,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerType.setAdapter(adapter);

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        break;
                    case 1:
                        Intent intentB =new Intent(Week_Activity_TypeB.this, Week_Acitivity_TypeA.class);
                        startActivity(intentB);
                        finish();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        ViewGroup layout1 = (ViewGroup) findViewById(R.id.PlanEB);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Week_Activity_TypeB.this, PlanEdit.class);
                startActivity(intent);
            }


        });

        ViewGroup layout2 = (ViewGroup) findViewById(R.id.MonthWB);
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Week_Activity_TypeB.this, MainActivity.class);
                startActivity(intent);
                finish();
            }


        });

        ViewGroup layout3 = (ViewGroup) findViewById(R.id.WeekWB);
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Week_Activity_TypeB.this, Week_Activity_TypeB.class);
                startActivity(intent);
                finish();
            }


        });

        ViewGroup layout4 = (ViewGroup) findViewById(R.id.DayInfoWB);
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Week_Activity_TypeB.this, MainActivity.class);
                startActivity(intent);
            }


        });

    }
}
