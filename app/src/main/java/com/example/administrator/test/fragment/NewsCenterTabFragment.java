package com.example.administrator.test.fragment;


import android.view.View;

import com.example.administrator.test.activity.NewsCenterActivity;
import com.example.administrator.test.base.BaseFragment;
import com.example.administrator.test.base.BaseLoadNetDataOperator;
import com.example.administrator.test.bean.NewsCenterBean;
import com.example.administrator.test.utils.Constant;
import com.example.administrator.test.utils.Utils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/4/16.
 */

public class NewsCenterTabFragment extends BaseFragment implements BaseLoadNetDataOperator{

    private NewsCenterBean mNewsCenterBean;

    @Override
    public void initTitle() {
        setIbMenuDisplayState(true);
        setIbPicTypeDisplayState(false);
        setTitle("新闻中心");
    }

    @Override
    public View creatContent() {
        return null;
    }

    @Override
    public void loadNetData() {
        String url = Constant.NEWSCENTER_URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Utils.MyToast(getContext(),"获取数据失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        processData(response);
                    }
                });
    }

    public void processData(String json) {
        Gson mGson = new Gson();
        mNewsCenterBean = mGson.fromJson(json, NewsCenterBean.class);
        //把数据传递给Activity
        ((NewsCenterActivity)getActivity()).setmNewsCenterMenuBeanList(mNewsCenterBean.data);
    }
}