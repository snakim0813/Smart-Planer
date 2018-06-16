
package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;


public class PlanEdit extends Activity {

    Button button;

    EditText PlanNameView;
    EditText PlanLocationView;
    TimePicker StartTime;
    TimePicker EndTime;

    Button actionView; //현재 버튼 설정이 없음 연결 할수 없음

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.planedit);

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

                    String insertSQL = "insert into s_time(" +
                            "start_time_hour, " +
                            "start_time_min, " +
                            "end_time_hour, " +
                            "end_time_min, " +
                            "content, " +
                            "place) " +
                            "values(" +
                            starthour + ", " +
                            startmin + ", " +
                            endhour + ", " +
                            endtmin + ", " +
                            "'" + content + "', " +
                            "'" + place + "') ";

                    db.execSQL(insertSQL);
                    db.close();

                    Toast toast = Toast.makeText(getApplicationContext(), "일정이 저장 되었습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });




    }
}