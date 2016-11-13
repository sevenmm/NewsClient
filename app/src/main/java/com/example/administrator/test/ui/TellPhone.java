package com.example.administrator.test.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.test.R;
import com.example.administrator.test.utils.Utils;

public class TellPhone extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_phone);

        Button button = (Button) findViewById(R.id.btn_tell);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hasCallPhonePermission = checkSelfPermission(Manifest.permission.CALL_PHONE);
                if (hasCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(TellPhone.this
                            ,new String[]{Manifest.permission.CALL_PHONE}
                            ,0);
                    return;
                }

               editText = (EditText) findViewById(R.id.et_number);
                String number = editText.getText().toString().trim();
                Intent intentPhone = new Intent();
                intentPhone.setAction(Intent.ACTION_CALL);
                intentPhone.setData(Uri.parse("tel:" + number));
                startActivity(intentPhone);
                Utils.MyToast(TellPhone.this, "短信已发送");
            }
        });
    }
}
