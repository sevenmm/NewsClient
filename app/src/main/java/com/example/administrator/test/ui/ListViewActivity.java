package com.example.administrator.test.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.test.R;
import com.example.administrator.test.utils.Utils;

public class ListViewActivity extends AppCompatActivity {

    private Button btn_back;
    private Context context;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = this;
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Utils.MyToast(context, "您点击了第" + i + "条item");
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
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

            ViewHolder mViewHolder;
            if (view == null) {
                mViewHolder = new ViewHolder();
                view = View.inflate(context, R.layout.item_simplelistview, null);
                mViewHolder.imageView = (ImageView) view.findViewById(R.id.iv_simplelistview);
                mViewHolder.textView = (TextView) view.findViewById(R.id.tv_simplelistview);
                view.setTag(mViewHolder);
            }
            mViewHolder = (ViewHolder) view.getTag();

            mViewHolder.imageView.setImageResource(R.drawable.ic_launcher);
            mViewHolder.textView.setText("这是第" + i + "条item");

            return view;
        }

        private class ViewHolder {
            private ImageView imageView;
            private TextView textView;
        }
    }

}
