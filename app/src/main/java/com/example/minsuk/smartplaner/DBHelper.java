package com.example.minsuk.smartplaner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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

        //테이블 작성구간
        //테이블 작성 문장을 s_dateSQL에 스트링 형식으로 서장
        String s_dateSQL = "create table s_date(" +
                "_id integer primary key autoincrement, " +
                "year integer, " +
                "month integer, " +
                "day integer)";

        //테이블 작성 문장을 s_timeSQL에 스트링 형식으로 서장
        String s_timeSQL =  "create table s_time(" +
                "_id integer primary key autoincrement, " +
                "date_id integer, " +
                "start_time_hour integer, " +
                "start_time_min integer, " +
                "end_time_hour integer, " +
                "end_time_min integer, " +
                "color text, " +
                "content text not null, " +
                "place, text" +
                "s_information_ID integer)";

        String s_typeSQL =  "create table s_type(" +
                "_id integer primary key autoincrement, " +
                "name text not null)";

        String s_detailSQL =  "create table s_detail(" +
                "_id integer primary key autoincrement, " +
                "name text not null, "  +
                "s_type_ID integer)";

        String s_informationSQL =  "create table s_information(" +
                "_id integer primary key autoincrement, " +
                "name text not null, "  +
                "s_informationSQL text, " +
                "s_detail_ID integer)";

        db.execSQL(s_dateSQL); // SQLite에 _dataSQL 문장을 실행한다.
        db.execSQL(s_timeSQL); // SQLite에 s_timeSQL 문장을 실행한다.

        db.execSQL(s_typeSQL);
        db.execSQL(s_detailSQL);
        db.execSQL(s_informationSQL);

        //데이터 삽입 구간
        //s_typeSQL(type_activity의 메뉴들) 카테고리 데이터 삽입
        String insertSQL = "insert into s_type(name) values('exercise')";
        db.execSQL(insertSQL);
        insertSQL = "insert into s_type(name) values('study')";
        db.execSQL(insertSQL);
        insertSQL = "insert into s_type(name) values('travel')";
        db.execSQL(insertSQL);
        insertSQL = "insert into s_type(name) values('menu')";
        db.execSQL(insertSQL);

        insertSQL = "select _id from s_type where name = 'exercise'";
        Cursor cursor = db.rawQuery(insertSQL, null);
        String _id =  cursor.getString(0);
        int i_id = Integer.parseInt(_id);

        insertSQL = "insert into s_detail(name, s_type_ID) " +
                "values('jump_rope', i_id)";
        db.execSQL(insertSQL);

        insertSQL = "select _id from s_detail where name = 'jogging'";
        cursor = db.rawQuery(insertSQL, null);
        _id =  cursor.getString(0);
        i_id = Integer.parseInt(_id);

        insertSQL = "insert into s_information(name, s_informationSQL, s_detail_ID) " +
                "values('jogging', '조깅입니다.', i_id)";
        db.execSQL(insertSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade는 위에 DATABASE_VERSION이 변경될때마다 호출이 된다.
        //스키마 변경 목적으로 함수를 이용한다.

        if(newVersion == DATABASE_VERSION) {
            db.execSQL("drop table s_date"); //생성된 s_date 테이블을 제거한다.
            db.execSQL("drop table s_time"); //생성된 s_time 테이블을 제거한다.

            db.execSQL("drop table s_type");
            db.execSQL("drop table s_detail");
            db.execSQL("drop table s_information");
            onCreate(db);
        }
    }
}
