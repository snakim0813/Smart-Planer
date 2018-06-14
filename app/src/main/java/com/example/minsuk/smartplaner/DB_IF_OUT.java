package com.example.minsuk.smartplaner;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DB_IF_OUT extends AppCompatActivity implements View.OnCreateContextMenuListener {

    ImageButton exercise, study, travel, menu;

    ImageButton exJogging;
    //DetailEx2

    String type, detail;

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.type_activity);
        exercise=(ImageButton)findViewById(R.id.TypeButton1);
        study=(ImageButton)findViewById(R.id.TypeButton2);
        travel=(ImageButton)findViewById(R.id.TypeButton3);
        menu=(ImageButton)findViewById(R.id.TypeButton4);

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "exercise";
            }
        });
        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "study";
            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "travel";
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "menu";
            }
        });

        setContentView(R.layout.detail_exercise);

        final DBHelper helper = new DBHelper(this);

        exJogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                detail = "jogging";

                String readSQL;
                Cursor cursor;

                SQLiteDatabase db = helper.getReadableDatabase();

                readSQL = "select s_informationSQL from s_information where name =" + "'" + detail + "'";
                cursor = db.rawQuery(readSQL, null);
                String text =  cursor.getString(0);

                setContentView(R.layout.detail_running);
                TextView textView=(TextView)findViewById(R.id.running_text);
                textView.setText(text);

                db.close();
            }
        });

    }
}
