package com.example.administrator.test.fragment;


import android.view.View;

import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/16.
 */

public class SmartServiceTabFragment extends BaseFragment {

    @Override
    public void initTitle() {
        setIbMenuDisplayState(true);
        setIbPicTypeDisplayState(false);
        setTitle("生活");
    }

    @Override
    public View creatContent() {
        return null;
    }
}
