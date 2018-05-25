package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class DetailEx extends Activity {

    ImageButton buttonDtailinfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.detail_exercise);

        buttonDtailinfo = (ImageButton) findViewById(R.id.DetailEx2);
        buttonDtailinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailEx.this, Detailinfo.class));
            }
        });
    }
}
