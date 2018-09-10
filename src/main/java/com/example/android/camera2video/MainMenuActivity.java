package com.example.android.camera2video;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    public void choseRecord(View view)
    {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    public void choseVote(View view)
    {

    }

}
