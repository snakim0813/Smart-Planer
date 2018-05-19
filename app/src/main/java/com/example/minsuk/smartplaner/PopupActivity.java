package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class PopupActivity extends Activity{

    ImageButton buttonDtailEx;
    protected void  onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.type_activity);

        buttonDtailEx =(ImageButton) findViewById(R.id.TypeButton1);
        buttonDtailEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopupActivity.this,DetailEx.class));
            }
        });
    }
}
