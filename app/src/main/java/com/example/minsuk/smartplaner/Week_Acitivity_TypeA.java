package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Week_Acitivity_TypeA extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        String stringDate = "";

        int WeekYear[] = new int[7];
        int WeekMon[] = new int[7];
        int WeekDay[] = new int[7];
        TextView 요일[] = new TextView[7]; //

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_week_a_type);

        요일[0] = (TextView)findViewById(R.id.일요일);
        요일[1] = (TextView)findViewById(R.id.월요일);
        요일[2] = (TextView)findViewById(R.id.화요일);
        요일[3] = (TextView)findViewById(R.id.수요일);
        요일[4] = (TextView)findViewById(R.id.목요일);
        요일[5] = (TextView)findViewById(R.id.금요일);
        요일[6] = (TextView)findViewById(R.id.토요일);
        TextView 정보 = (TextView)findViewById(R.id.정보);

        Intent intent = getIntent();
        int mYear = intent.getIntExtra("mYear", 0);
        int mMonth = intent.getIntExtra("mMonth", 0);
        int mDay = intent.getIntExtra("mDay", 0);
        String mWeek = intent.getStringExtra("mWeek");

        Calendar cal= Calendar.getInstance ();
        cal.set(mYear, mMonth - 1, mDay); //받아온 날짜 세팅
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        if(mWeek.equals("일요일")) {

        }
        else if (mWeek.equals("월요일"))  {
            cal.add(Calendar.DATE, -1);
        }
        else if (mWeek.equals("화요일"))  {
            cal.add(Calendar.DATE, -2);
        }
        else if (mWeek.equals("수요일"))  {
            cal.add(Calendar.DATE, -3);
        }
        else if (mWeek.equals("목요일"))  {
            cal.add(Calendar.DATE, -4);
        }
        else if (mWeek.equals("금요일"))  {
            cal.add(Calendar.DATE, -5);
        }
        else if (mWeek.equals("토요일"))  {
            cal.add(Calendar.DATE, -6);
        }

        stringDate = dateFormat.format(cal.getTime()); //일주일 시작 날짜 구함

        for(int i = 0; i<7; i++) {
            WeekYear[i] = Integer.parseInt(stringDate.substring(0, 4));
            WeekMon[i] = Integer.parseInt(stringDate.substring(4, 6));
            WeekDay[i] = Integer.parseInt(stringDate.substring(6, 8));
            cal.add(Calendar.DATE, +1);
            stringDate = dateFormat.format(cal.getTime());
        }


        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        for(int i = 0; i<7; i++) {
            String inputSQL = "select s_time.content " +
                    "from s_date, s_time " +
                    "where s_date.year = " + WeekYear[i] + " " +
                    "and s_date.month = " + WeekMon[i] + " " +
                    "and s_date.day = " + WeekDay[i] + " " +
                    "and s_date._id = s_time._id " +
                    "order by s_time._id";

            String text="";

            Cursor cursor = db.rawQuery(inputSQL, null);


            try {
                if (cursor != null && cursor.moveToFirst()) {
                    text = cursor.getString(0);
                }
            }
            finally {
                if(cursor != null) {
                    cursor.close();
                }
            }

            cursor.close();

            요일[i].setText(text);
        }


        db.close();



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
