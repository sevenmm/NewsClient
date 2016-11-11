package com.example.administrator.test.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.test.R;
import com.example.administrator.test.utils.Utils;

public class SmsMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_message);

        final EditText et_number = (EditText) findViewById(R.id.et_number);
        final EditText et_content = (EditText) findViewById(R.id.et_content);
        Button send = (Button) findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hasSendMessagePermission = checkSelfPermission(Manifest.permission.SEND_SMS);
                if (hasSendMessagePermission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SmsMessage.this
                            , new String[]{Manifest.permission.SEND_SMS}, 0);
                    return;
                }

                String number = et_number.getText().toString().trim();
                String content = et_content.getText().toString().trim();
                if (TextUtils.isEmpty(number) || TextUtils.isEmpty(content)) {
                    Utils.MyToast(SmsMessage.this, "号码或内容不能为空");
                } else {
                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.divideMessage(content);
                    smsManager.sendTextMessage(number, null, content, null, null);
                }
            }
        });

    }
}
