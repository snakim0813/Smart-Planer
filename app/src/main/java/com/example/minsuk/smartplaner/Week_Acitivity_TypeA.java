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

public class Week_Acitivity_TypeA extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_week_a_type);

       Spinner spinnerType =(Spinner)findViewById(R.id.TypeSelectionA);


       ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,R.array.Week_Type,android.R.layout.simple_spinner_item);

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
                            Intent intent =new Intent(Week_Acitivity_TypeA.this, Week_Activity_TypeB.class);
                            startActivity(intent);
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
                Intent intent = new Intent(Week_Acitivity_TypeA.this, PlanEdit.class);
                startActivity(intent);
            }


        });

        ViewGroup layout2 = (ViewGroup) findViewById(R.id.MonthWA);
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Week_Acitivity_TypeA.this, MainActivity.class);
                startActivity(intent);
                finish();
            }


        });

        ViewGroup layout3 = (ViewGroup) findViewById(R.id.WeekWa);
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Week_Acitivity_TypeA.this, Week_Acitivity_TypeA.class);
                startActivity(intent);
                finish();
            }


        });

        ViewGroup layout4 = (ViewGroup) findViewById(R.id.DayInfoWA);
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Week_Acitivity_TypeA.this, MainActivity.class);
                startActivity(intent);
            }


        });

    }
}
