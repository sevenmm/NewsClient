package com.example.administrator.test.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.test.R;
import com.example.administrator.test.utils.Utils;

public class SaveToLocal extends AppCompatActivity {

    private EditText userName;
    private EditText passWorld;
    private Context context = SaveToLocal.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_to_local);

        userName = (EditText) findViewById(R.id.et_user);
        passWorld = (EditText) findViewById(R.id.et_passworld);

    }

    public void saveInfo(View view) {
        String name = userName.getText().toString().trim();
        String pass = passWorld.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
            Utils.MyToast(context, "用户名或密码不能为空");
        } else {
            SharedPreferences preferences = context.getSharedPreferences("007info", Context.MODE_NO_LOCALIZED_COLLATORS);
            SharedPreferences.Editor edit = preferences.edit();
            edit.putString("用户名", name);
            edit.putString("密码", pass);
            edit.commit();

//            Utils.MyToast(context,"已经保存");
        }
    }

}
