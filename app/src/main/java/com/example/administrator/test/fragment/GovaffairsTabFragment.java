package com.example.administrator.test.fragment;


import android.view.View;

import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/16.
 */

public class GovaffairsTabFragment extends BaseFragment {

    @Override
    public void initTitle() {
        setIbMenuDisplayState(false);
        setIbPicTypeDisplayState(false);
        setTitle("人口管理");
    }

    @Override
    public View creatContent() {
        return null;
    }
}
