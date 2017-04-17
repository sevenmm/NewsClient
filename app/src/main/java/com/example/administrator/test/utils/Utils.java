package com.example.administrator.test.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by 007 on 2016/11/11.
 */

public class Utils {
    public static void MyToast(Context context,String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }


    private static String str = null;
    public static String netWork(final Context context, String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new MyStringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                str = s;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context,"访问网络数据失败",Toast.LENGTH_SHORT).show();
            }
        });
        return str;
    }
}
