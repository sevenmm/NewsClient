package com.example.administrator.test.fragment;

import android.widget.TextView;

import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/16.
 */

public class GovaffairsTabFragment extends BaseFragment {

    @Override
    public void setContent() {
        //getText(); 是获取onCreatView()创建的View
        ((TextView)getView()).setText("这是政务的内容");
    }
}
