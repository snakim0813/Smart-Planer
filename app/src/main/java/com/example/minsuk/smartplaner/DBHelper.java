package com.example.minsuk.smartplaner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //SQLiteOpenHelper클래스를 상속받아 생성한다.
    //SQLiteOpenHelper는 데이터베이스 생성 및 버전 관리를 관리하는 도우미 클래스이다.

    public static final int DATABASE_VERSION=1;

    public DBHelper(Context context) {
        super(context, "plannerdb", null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //어플린케이션이 인스톨된 후에 DBHelper클래스가 각종에 소스코드에서 최초로 이용될때 단 한번 호출된다.
        //생성된 DB가 없으면 호출된다.
        //테이블 생성 작업이 시작되는 곳이다.

        //테이블 작성 문장을 s_dataSQL에 스트링 형식으로 서장
        String s_dataSQL = "create table s_date(" +
                "_id integer primary key autoincrement, " +
                "year integer, " +
                "month integer, " +
                "day integer)";

        //테이블 작성 문장을 s_timeSQL에 스트링 형식으로 서장
        String s_timeSQL =  "create table s_time(" +
                "_id integer primary key autoincrement, " +
                "date_id integer, " +
                "start_time integer, " +
                "end_time integer, " +
                "color text, " +
                "content text)";

        db.execSQL(s_dataSQL); // SQLite에 _dataSQL 문장을 실행한다.
        db.execSQL(s_timeSQL); // SQLite에 s_timeSQL 문장을 실행한다.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade는 위에 DATABASE_VERSION이 변경될때마다 호출이 된다.
        //스키마 변경 목적으로 함수를 이용한다.

        if(newVersion == DATABASE_VERSION) {
            db.execSQL("drop table s_date"); //생성된 s_date 테이블을 제거한다.
            db.execSQL("drop table s_time"); //생성된 s_time 테이블을 제거한다.
            onCreate(db);
        }
    }
}
