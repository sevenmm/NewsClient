package com.example.administrator.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/16.
 */

public class SettingTabFragment extends BaseFragment {

    @Override
    public void setContent() {
        //getText(); 是获取onCreatView()创建的View
        ((TextView)getView()).setText("这是设置的内容");
    }
}