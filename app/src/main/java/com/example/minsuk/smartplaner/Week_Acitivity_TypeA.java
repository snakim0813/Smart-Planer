package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class Week_Acitivity_TypeA extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_week_a_type);

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
                Intent intent=new Intent(Week_Acitivity_TypeA.this, CalendarActivity.class);
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

        ViewGroup layout4 = (ViewGroup) findViewById(R.id.DayInfoM);
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Week_Acitivity_TypeA.this, MainActivity.class);
                startActivity(intent);
            }


        });

    }
}
