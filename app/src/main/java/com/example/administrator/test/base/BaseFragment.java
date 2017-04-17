package com.example.administrator.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.test.R;
import com.example.administrator.test.activity.NewsCenterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/16.
 */

public abstract class BaseFragment extends Fragment {
    @BindView(R.id.ib_menu)
    ImageButton ibMenu;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ib_pic_type)
    ImageButton ibPicType;
    @BindView(R.id.container)
    FrameLayout container;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_tab_base, null);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitle();
    }

    //初始化标题栏，让每个子类去实现
    public abstract void initTitle();

    //创建内容
    public abstract View creatContent();

    //向容器里添加内容
    public void addView(View view) {
        container.removeAllViews();
        container.addView(view);
    }

    //设置标题文字
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    //设置menu是否显示
    public void setIbMenuDisplayState(boolean isShow){
        ibMenu.setVisibility(isShow? View.VISIBLE:View.GONE);
    }

    //设置picType是否显示
    public void setIbPicTypeDisplayState(boolean isShow) {
        ibPicType.setVisibility(isShow?View.VISIBLE:View.GONE);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ib_menu)
    public void onViewClicked() {
        ((NewsCenterActivity)getActivity()).slidingMenu.toggle();
    }
}
