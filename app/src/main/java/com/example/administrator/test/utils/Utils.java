package com.example.administrator.test.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 007 on 2016/11/11.
 */

public class Utils {
    public static void MyToast(Context context,String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
