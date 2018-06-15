package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;

public class Detailinfo extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();


        String inputSQL = "select s_informationSQL from s_information where name = 'jogging'";
        Cursor cursor = db.rawQuery(inputSQL, null);
        db.close();

        String text="";

        try {
            text = (new String(cursor.getBlob(0), "utf-8"));
            cursor.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        setContentView(R.layout.detail_running);
        TextView textView=(TextView)findViewById(R.id.running_text);

       textView.setText(text);
    }
}
