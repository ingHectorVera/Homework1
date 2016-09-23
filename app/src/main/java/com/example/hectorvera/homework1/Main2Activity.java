package com.example.hectorvera.homework1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    TextView txtView_2;
    ImageView imageFromCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageFromCamera = ((ImageView) findViewById(R.id.imageFromCamera));
        Intent mActivity2 = getIntent();
        txtView_2 = ((TextView) findViewById(R.id.txtView_2));
        txtView_2.setText(mActivity2.getStringExtra("iTakePicture"));
        displayCamera();

    }

    private void displayCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap bImagenFromCamara = (Bitmap) extras.get("data");
            imageFromCamera.setImageBitmap(bImagenFromCamara);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("sTxtView_2", txtView_2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtView_2.setText(savedInstanceState.getString("sTxtView_2","Default"));
    }
}
