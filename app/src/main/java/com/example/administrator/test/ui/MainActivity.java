package com.example.administrator.test.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.test.R;
import com.example.administrator.test.utils.Utils;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends SlidingFragmentActivity {

    Context mContext = MainActivity.this;
    private ListView lvFunction;
    private String url = "http://192.168.31.118:8080/007/list_1.json";
    private String[] functions = new String[]{"时间提醒", "SimpleListView",
            "电话拨号器", "短信发送器", "Save to Local", "图片搜索", "下拉刷新", "新闻客户端"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);


        //侧拉菜单
        SlidingMenu slidingmenu = getSlidingMenu();
        setBehindContentView(R.layout.slidingmenu_layout);
        slidingmenu.setBehindWidth(800);
        slidingmenu.setMode(SlidingMenu.LEFT);
        slidingmenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);


        //访问网络
//        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        //StringRequest
//        StringRequest stringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                Utils.MyToast(mContext,s);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Utils.MyToast(mContext,"获取网络数据失败");
//            }
//        });
//        requestQueue.add(stringRequest);

        //JsonObjectRequest
        //1.会出现乱码
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                Utils.MyToast(mContext, jsonObject.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Utils.MyToast(mContext,"访问网络数据失败");
//            }
//        });

        //2.自定义JsonObjectRequest,修改了乱码问题
//        JsonObjectRequest jsonObjectRequest = new MyJsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                try {
//                    jsonObject0 = jsonObject;
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Utils.MyToast(mContext,"访问网络数据失败");
//            }
//        });

//        requestQueue.add(jsonObjectRequest);

//        String response = Utils.netWork(mContext, url);
//        toList = JsonUtil.parseJsonToList(response, null);

        lvFunction = (ListView) findViewById(R.id.lv_function);
        lvFunction.setAdapter(new MyFunctionAdapter());
        lvFunction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (functions[i]) {
                    case "时间提醒":
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date = format.format(new Date(System.currentTimeMillis()));
                        Utils.MyToast(mContext, date);
                        break;
                    case "SimpleListView":
                        newActivity(mContext, ListViewActivity.class);
                        break;
                    case "电话拨号器":
                        newActivity(mContext, TellPhone.class);
                        break;
                    case "短信发送器":
                        newActivity(mContext, SmsMessage.class);
                        break;
                    case "Save to local":
                        newActivity(mContext, SaveToLocal.class);
                        break;
                    case "图片搜索":
                        newActivity(mContext, ImageActivity.class);
                        break;
                    case "下拉刷新":
                        newActivity(mContext, RefershListView.class);
                        break;
                    case "新闻客户端":
                        newActivity(mContext, NewsCenterActivity.class);
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

    public void newActivity(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        startActivity(intent);
    }

}
