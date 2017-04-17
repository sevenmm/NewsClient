package com.example.administrator.test.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.test.R;
import com.example.administrator.test.base.BaseFragment;
import com.example.administrator.test.utils.Utils;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/4/16.
 */

public class HomeTabFragment extends Fragment {

    private View view;
    private TextView textView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.picasso_layout,null);
        textView = (TextView) view.findViewById(R.id.tv_okhttp);
        button = (Button) view.findViewById(R.id.btn_picasso);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNet();
            }
        });

        return view;
    }

    private void getNet() {
        OkHttpUtils.get().url("http://10.0.2.2:8080/007/list_1.json").build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        textView.setText(response);
                    }

                });
    }
}
