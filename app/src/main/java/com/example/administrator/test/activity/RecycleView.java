package com.example.administrator.test.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.test.R;

/**
 * Created by Administrator on 2017/5/5.
 */

class RecycleView extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

//        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
//        lm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager lm = new GridLayoutManager(getApplicationContext(),2);
        lm.setOrientation(GridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lm);
//        recyclerView.addItemDecoration(new MyItemDecoration());
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyRecyclerAdapter());
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getApplicationContext(), R.layout.test_item_recyclerview, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.setData(position);
        }

        @Override
        public int getItemCount() {
            return 55;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }

        public void setData(int position) {
            int i = position + 1;
            textView.setText("第"+ i + "个条目");
        }
    }

    //分割线：有bug，无效果
/*    private class MyItemDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //设定底部边距为1px
            outRect.set(0, 0, 0, 1);
        }

    }*/

}
