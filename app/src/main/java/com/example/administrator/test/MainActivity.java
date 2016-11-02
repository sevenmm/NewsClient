package com.example.administrator.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends Activity {

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


    }

    public void onNewActivity(View view) {
        Intent intent = new Intent(mContext, Main2Activity.class);
        startActivity(intent);
        finish();

    }

}
