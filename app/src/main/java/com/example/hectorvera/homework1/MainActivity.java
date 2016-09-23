package com.example.hectorvera.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView take_picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        take_picture = ((TextView) findViewById(R.id.take_picture));
    }

    public void callCamera(View view) {
        Intent mActivity2 = new Intent(this, Main2Activity.class);
        mActivity2.putExtra("iTakePicture", take_picture.getText().toString());
        Log.d("FMT", take_picture.getText().toString());
        startActivityForResult(mActivity2, 1);
    }
}