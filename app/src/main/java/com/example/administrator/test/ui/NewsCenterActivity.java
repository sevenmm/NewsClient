package com.example.administrator.test.ui;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.test.R;
import com.example.administrator.test.adapter.TabAdapter;
import com.example.administrator.test.fragment.GovaffairsTabFragment;
import com.example.administrator.test.fragment.HomeTabFragment;
import com.example.administrator.test.fragment.NewsCenterTabFragment;
import com.example.administrator.test.fragment.SettingTabFragment;
import com.example.administrator.test.fragment.SmartServiceTabFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsCenterActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private RadioGroup mRadioGroup;
    private RadioButton rb_home;
    private RadioButton rb_smartservice;
    private RadioButton rb_govaffairs;
    private RadioButton rb_newscenter;
    private RadioButton rb_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_center);

        initView();
        initVP();
    }

    //初始化控件
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        //设置选择改变监听
        mRadioGroup.setOnCheckedChangeListener(this);

        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_smartservice = (RadioButton) findViewById(R.id.rb_smartservice);
        rb_govaffairs = (RadioButton) findViewById(R.id.rb_govaffairs);
        rb_newscenter = (RadioButton) findViewById(R.id.rb_newscenter);
        rb_setting = (RadioButton) findViewById(R.id.tb_setting);



    }

    //初始化ViewPager
    private void initVP() {
        fragments = new ArrayList<>();
        fragments.add(new HomeTabFragment());
        fragments.add(new NewsCenterTabFragment());
        fragments.add(new SmartServiceTabFragment());
        fragments.add(new GovaffairsTabFragment());
        fragments.add(new SettingTabFragment());
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(tabAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        int item = 0;
        switch (i){
            case R.id.rb_home:
                item = 0;
                break;
            case R.id.rb_newscenter:
                item = 1;
                break;
            case R.id.rb_smartservice:
                item = 2;
                break;
            case R.id.rb_govaffairs:
                item = 3;
                break;
            case R.id.tb_setting:
                item = 4;
                break;
        }
        mViewPager.setCurrentItem(item,false); //false 去点点击tab切换ViewPager的滑动动画；
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                rb_home.setChecked(true);
                break;
            case 1:
                rb_newscenter.setChecked(true);
                break;
            case 2:
                rb_smartservice.setChecked(true);
                break;
            case 3:
                rb_govaffairs.setChecked(true);
                break;
            case 4:
                rb_setting.setChecked(true);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
