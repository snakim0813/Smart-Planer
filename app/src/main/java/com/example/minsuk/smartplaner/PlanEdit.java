
package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class PlanEdit extends Activity {

    Button button;

    EditText PlanNameView;
    EditText PlanLocationView;
    TimePicker StartTime;
    TimePicker EndTime;
    TextView DateView;

    Button actionView; //현재 버튼 설정이 없음 연결 할수 없음
    Button cencleView;

    int mYear;
    int mMonth;
    int mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.planedit);

        Intent intent = getIntent();
        mYear = intent.getIntExtra("mYear", 0);
        mMonth = intent.getIntExtra("mMonth", 0);
        mDay = intent.getIntExtra("mDay", 0);
        String mWeek = intent.getStringExtra("mWeek");

        String  str = String.format("%d.%d.%d %s",mYear,mMonth,mDay,mWeek);

        DateView=(TextView)findViewById(R.id.DateView);
        DateView.setText(str);

        button = (Button) findViewById(R.id.PlanType);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlanEdit.this, PopupActivity.class));
            }
        });

        PlanNameView=(EditText)findViewById(R.id.PlanName);
        PlanLocationView=(EditText)findViewById(R.id.PlanLocation);
        StartTime=(TimePicker)findViewById(R.id.tpS);
        EndTime=(TimePicker)findViewById(R.id.tpE);
        actionView=(Button)findViewById(R.id.OKe);
        cencleView=(Button)findViewById(R.id.NOe);

        final DBHelper helper = new DBHelper(this);

        actionView.setOnClickListener(new View.OnClickListener() { //버튼 클릭이 일어났을때
            @Override
            public void onClick(View v) {
                String content;            //일정내용
                String place;              //장소
                int starthour;    //시작시간
                int startmin;     //시작 분
                int endhour;      //끝 시간
                int endtmin;       //끝 분

                content = PlanNameView.getText().toString();
                place = PlanLocationView.getText().toString();


                //TimePicker에서 시작시간과 끝시간을 불러온다.
                starthour = StartTime.getCurrentHour();
                startmin = StartTime.getCurrentMinute();
                endhour = EndTime.getCurrentHour();
                endtmin = EndTime.getCurrentMinute();

                if(content == null || content.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "메모를 작성하세요.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else { //일정내용이 존재할때
                    SQLiteDatabase db = helper.getWritableDatabase();

                    String insertSQL = "insert into s_date(" +
                            "year, " +
                            "month, " +
                            "day) " +
                            "values(" +
                            mYear + ", " +
                            mMonth + ", " +
                            mDay + ") ";

                    db.execSQL(insertSQL);

                    insertSQL = "select _id " +
                            "from s_date " +
                            "where year = " + mYear + " " +
                            "and month = " + mMonth + " " +
                            "and day = " + mDay + " " +
                            "order by _id";

                    Cursor cursor = db.rawQuery(insertSQL, null);

                    int s_date_id=0;

                    try {
                        if (cursor != null && cursor.moveToFirst()) {
                            s_date_id = cursor.getInt(0);
                        }
                    }
                    finally {
                        if(cursor != null) {
                            cursor.close();
                        }
                    }
                    cursor.close();


                    insertSQL = "insert into s_time(" +
                            "start_time_hour, " +
                            "start_time_min, " +
                            "end_time_hour, " +
                            "end_time_min, " +
                            "content, " +
                            "place, " +
                            "date_id) " +
                            "values(" +
                            starthour + ", " +
                            startmin + ", " +
                            endhour + ", " +
                            endtmin + ", " +
                            "'" + content + "', " +
                            "'" + place + "', " +
                            s_date_id + ") ";

                    db.execSQL(insertSQL);

                    db.close();

                    Toast toast = Toast.makeText(getApplicationContext(), "일정이 저장 되었습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }
            }
        });

        cencleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT);
                toast.show();

                finish();
            }
        });

    }
}