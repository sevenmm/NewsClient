package com.example.administrator.test.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.test.R;
import com.example.administrator.test.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends Activity {

    Context mContext = MainActivity.this;
    private ListView lvFunction;
    private String[] functions = new String[]{"时间提醒","SimpleListView","电话拨号器","短信发送器"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);

        lvFunction = (ListView) findViewById(R.id.lv_function);
        lvFunction.setAdapter(new MyFunctionAdapter());
        lvFunction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (functions[i]) {
                    case "时间提醒":
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date = format.format(new Date(System.currentTimeMillis()));
                        Utils.MyToast(mContext,date);
                        break;
                    case "SimpleListView":
                        newActivity(mContext, Main2Activity.class);
                        break;
                    case "电话拨号器":
                        newActivity(mContext, TellPhone.class);
                        break;
                    case "短信发送器":
                        newActivity(mContext, SmsMessage.class);
                        break;
                }
            }
        });

    }

    private class MyFunctionAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return functions.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(functions[i]);
            textView.setTextSize(25);
            textView.setHeight(250);
            textView.setGravity(Gravity.CENTER);
            return textView;
        }
    }

    public void newActivity(Context context,Class clazz) {
        Intent intent = new Intent(context, clazz);
        startActivity(intent);
    }

}
