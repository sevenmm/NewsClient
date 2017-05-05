package com.example.administrator.test.fragment;

import android.view.View;

import com.example.administrator.test.base.BaseFragment;
import com.example.administrator.test.base.BaseLoadNetDataOperator;

/**
 * Created by Administrator on 2017/4/16.
 */

public class HomeTabFragment extends BaseFragment implements BaseLoadNetDataOperator{


    @Override
    public void initTitle() {
        setIbMenuDisplayState(false);
        setIbPicTypeDisplayState(false);
        setTitle("首页");
    }

    @Override
    public View creatContent() {
        return null;
    }

    @Override
    public void loadNetData() {

    }
}
