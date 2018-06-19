package com.example.minsuk.smartplaner;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Date;

import java.util.List;

import java.util.Locale;



import android.app.Activity;

import android.content.Context;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;

import android.view.View.OnClickListener;

import android.view.ViewGroup;

import android.view.Window;
import android.widget.BaseAdapter;

import android.widget.CalendarView;
import android.widget.GridView;

import android.widget.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.minsuk.smartplaner.R;
import com.example.minsuk.smartplaner.beans.Schedules;

import java.util.ArrayList;
import java.util.Calendar;



public class MainActivity extends Activity {

    CalendarView calendarView;

    private Calendar mCal;


    TextView DateNow;

    int mYear = 0;
    int mMonth = 0;
    int mDay = 0;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_main);

        ////클릭시 년월일을 불러오는 작업

        calendarView = (CalendarView)findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                mYear   = year;
                mMonth = month;
                mDay  = dayOfMonth;

                //확인 작업 부분
                Toast toast = Toast.makeText(getApplicationContext(), mYear +"."+mMonth +"."+mDay , Toast.LENGTH_SHORT);
                toast.show();

                getScheduleList(mYear + "" + (mMonth + 1) + "" + mDay);
            }
        });







        // 오늘에 날짜를 세팅 해준다.

        long now = System.currentTimeMillis();

        final Date date = new Date(now);



        mCal = Calendar.getInstance();



        final DBHelper helper = new DBHelper(this);

        ViewGroup layout1 = (ViewGroup) findViewById(R.id.PlanMEB);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                db.close();
                Intent intent = new Intent(MainActivity.this, PlanEdit.class);
                startActivity(intent);
            }


        });


        ViewGroup layout3 = (ViewGroup) findViewById(R.id.WeekMM);
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                db.close();
                Intent intent=new Intent(MainActivity.this, Week_Acitivity_TypeA.class);
                startActivity(intent);
                finish();
            }


        });

        ViewGroup layout4 = (ViewGroup) findViewById(R.id.DayInfoMM);
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                db.close();
                Intent intent = new Intent(MainActivity.this, Info_Selection_Day.class);
                startActivity(intent);
            }


        });

        Date DateC =  new Date(now);

        SimpleDateFormat Datenow = new SimpleDateFormat(" dd 일\n    ");

        String nowDate = Datenow.format(DateC);

        DateNow =(TextView)findViewById(R.id.Day);

        DateNow.setText(nowDate);

    }
////기본적으로 현제 날짜가 변수에 저장한다. 따라서 앱을 켤때에는 항상 현제 날짜에 체크
    protected void onResume() {
        super.onResume();

        if(mYear == 0 || mMonth == 0 || mDay == 0) {
            Calendar mcurrentDate = Calendar.getInstance();
            mYear   = mcurrentDate.get(Calendar.YEAR);
            mMonth = mcurrentDate.get(Calendar.MONTH);
            mDay  = mcurrentDate.get(Calendar.DAY_OF_MONTH);
        }

        getScheduleList(mYear + "" + (mMonth + 1) + "" + mDay);
    }

////디비에 비교 할때 쓰면 좋을거 같은느낌??
    private void getScheduleList(String date) {


        Schedules schedules = new Schedules();
        schedules.date = date;

    }









}

