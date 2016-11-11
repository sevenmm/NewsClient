package com.example.administrator.test;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends Activity implements View.OnClickListener {

    Context mContext = MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);

//        linearLayout = (LinearLayout) View.inflate(MainActivity.this, R.layout.test_main, null);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = format.format(new Date(System.currentTimeMillis()));
                Toast.makeText(mContext, date, Toast.LENGTH_SHORT).show();

            }
        });

        Button btn_tellphone = (Button) findViewById(R.id.btn_tellphone);
        Button btn_newworld = (Button) findViewById(R.id.btn_newworld);
        btn_tellphone.setOnClickListener(this);
        btn_newworld.setOnClickListener(this);


    }


    public void newActivity(Context context,Class clazz) {
        Intent intent = new Intent(context, clazz);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tellphone:
                newActivity(mContext,TellPhone.class);
                break;
            case R.id.btn_newworld:
                newActivity(mContext,Main2Activity.class);
                break;
        }
    }
}
