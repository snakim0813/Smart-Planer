/*
package com.example.minsuk.smartplaner;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.minsuk.smartplaner.DBHelper;
import com.example.minsuk.smartplaner.R;

import java.sql.SQLData;

public class AddPlanActivity extends AppCompatActivity implements View.OnCreateContextMenuListener{

    EditText PlanNameView;
    EditText PlanLocationView;
    Spinner HourStartView;
    Spinner MinStartView;
    Spinner HourEndView;
    Spinner MinEndView;

    Button actionView; //현재 버튼 설정이 없음 연결 할수 없음

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.planedit); //일정 추가 레이아웃이 완성되지 않아 일단 planedit 레이아웃으로 뷰를 잡아줬다.
        PlanNameView=(EditText)findViewById(R.id.PlanName);
        PlanLocationView=(EditText)findViewById(R.id.PlanLocation);
        HourStartView=(Spinner)findViewById(R.id.HourStart);
        MinStartView=(Spinner)findViewById(R.id.MinStart);
        HourEndView=(Spinner)findViewById(R.id.HourEnd);
        MinEndView=(Spinner)findViewById(R.id.MinEnd);


        //actionView=(Button)findViewById(R.id.); //버튼이 설정되거나 다른 입력장치 설정되면 추가 및 변경
        //actionView.setOnClickLsitener(this); //버튼 클릭이 일어났을때
    }

    public void onClick(View v) {
        String content;            //일정내용
        String place;              //장소
        String start_time_hour;    //시작시간
        String start_time_min;     //시작 분
        String end_time_hour;      //끝 시간
        String end_time_min;       //끝 분

        content = PlanNameView.getText().toString();
        place = PlanLocationView.getText().toString();

        start_time_hour = place = HourStartView.getSelectedItem().toString();
        start_time_min = place = MinStartView.getSelectedItem().toString();
        end_time_hour = place = HourEndView.getSelectedItem().toString();
        end_time_min = place = MinEndView.getSelectedItem().toString();

        //substring()함수를 이용해서 원하는 숫자부분만 저장한다.
        start_time_hour = start_time_hour.substring(0, 3);
        start_time_min = start_time_min.substring(0, 3);
        end_time_hour = end_time_hour.substring(0, 3);
        end_time_min = end_time_min.substring(0, 3);

        if(content == null || content.equals("")) {
            Toast toast = Toast.makeText(this, "메모를 작성하세요.", Toast.LENGTH_SHORT);
            toast.show();
        }
        else { //일정내용이 존재할때
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            String insertSQL = "insert into s_time(" +
                    "start_time_hour, " +
                    "start_time_min, " +
                    "end_time_hour, " +
                    "end_time_min, " +
                    "content, " +
                    "place) " +
                    "values(" +
                    start_time_hour + ", " +
                    start_time_min + ", " +
                    end_time_hour + ", " +
                    end_time_min + ", " +
                    "'" + content + "', " +
                    "'" + place + "') ";

            db.execSQL(insertSQL);
            db.close();
        }
    }
}
*/
