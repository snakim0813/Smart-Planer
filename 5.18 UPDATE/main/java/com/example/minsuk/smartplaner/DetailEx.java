package com.example.minsuk.smartplaner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class DetailEx extends Activity {
    protected void  onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.detail_exercise);
    }
}
