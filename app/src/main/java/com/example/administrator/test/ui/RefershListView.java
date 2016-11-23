package com.example.administrator.test.ui;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.test.R;
import com.example.administrator.test.view.RefreshListView;

import java.util.ArrayList;
import java.util.List;

public class RefershListView extends AppCompatActivity {

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refersh_list_view);

        final RefreshListView mRefershListView = (RefreshListView) findViewById(R.id.lv_refersh);
        final MyAdapter myAdapter = new MyAdapter();
        list = new ArrayList<String>();

        for (int i = 1; i <= 30; i++) {
            list.add("这是第" + i + "条数据");
        }
        mRefershListView.setAdapter(myAdapter);
        mRefershListView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullToRefresh() {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(1500);
                        list.add(0, "这是下拉刷新加载出来的数据...");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myAdapter.notifyDataSetChanged();
                                mRefershListView.onRefreshFinish();
                            }
                        });
                    }
                }).start();


            }
        });

    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
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

            TextView textView = new TextView(RefershListView.this);
            
            textView.setText(list.get(i));
            textView.setTextSize(25);
            return textView;
        }
    }

}
