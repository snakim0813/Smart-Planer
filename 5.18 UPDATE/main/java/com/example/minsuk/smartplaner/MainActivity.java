package com.example.minsuk.smartplaner;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner dateYear, dateMonth ,dateDay;

    String[] sYear, sMonth, sDay;

    ViewGroup layout1,layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



                dateYear = (Spinner)findViewById(R.id.dateYear);
        dateMonth = (Spinner)findViewById(R.id.dateMonth);
        dateDay = (Spinner)findViewById(R.id.dateDay);


        Calendar calendar = Calendar.getInstance();
        int maxYear = calendar.get(Calendar.YEAR);

        sYear = new String[20];
        sMonth = new String[12];
        sDay = new String[31];

        for(int i = 10-1, j = 0 ; i>=-10 ; i--, j++)
        {
            //정수 -> 문자열 후 배열에 삽입
            sYear[j] = String.valueOf(maxYear - i) + "년";
        }

        for(int i = 0 ; i<=11 ; i++)
        {
            //정수 -> 문자열 후 배열에 삽입
            sMonth[i] = String.valueOf(i+1) + "월";
        }

        for(int i = 0 ; i<=30 ; i++)
        {
            //정수 -> 문자열 후 배열에 삽입
            sDay[i] = String.valueOf(i+1) + "일";
        }

        ArrayAdapter sYearSpinnerAdapter, sMonthSpinnerAdapter, sDaySpinnerAdapter;
        sYearSpinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, sYear);
        sMonthSpinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, sMonth);
        sDaySpinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, sDay);
        dateYear.setAdapter(sYearSpinnerAdapter);
        dateMonth.setAdapter(sMonthSpinnerAdapter);
        dateDay.setAdapter(sDaySpinnerAdapter);

        dateYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        dateMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        dateDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ViewGroup layout1 = (ViewGroup) findViewById(R.id.PlanEB);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanEdit.class);
                startActivity(intent);
            }


        });

        ViewGroup layout5 = (ViewGroup) findViewById(R.id.Month1);
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
                finish();
            }


        });



    }
}
