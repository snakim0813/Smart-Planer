package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.ImageView;
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
        db.close();

        setContentView(R.layout.detail_running);

        ImageView iv = (ImageView)findViewById(R.id.iv);
        iv.setImageDrawable(getResources().getDrawable(R.drawable.info_jogging));

    }
}
