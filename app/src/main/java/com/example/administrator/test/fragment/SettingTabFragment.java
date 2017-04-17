package com.example.administrator.test.fragment;


import android.view.View;

import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/16.
 */

public class SettingTabFragment extends BaseFragment {

    @Override
    public void initTitle() {
        setIbMenuDisplayState(false);
        setIbPicTypeDisplayState(false);
        setTitle("设置");
    }

    @Override
    public View creatContent() {
        return null;
    }
}