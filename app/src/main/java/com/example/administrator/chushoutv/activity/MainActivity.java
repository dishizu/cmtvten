package com.example.administrator.chushoutv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.chushoutv.R;
import com.example.administrator.chushoutv.adapter.ViewPagerAdapter;
import com.example.administrator.chushoutv.fragment.HomeFragment;
import com.example.administrator.chushoutv.fragment.MineFragment;
import com.example.administrator.chushoutv.fragment.SubcribeFragment;
import com.example.administrator.chushoutv.fragment.ZoneFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener,View.OnClickListener {
    @BindView(R.id.tab_viewPager)
    ViewPager viewPager;
    @BindView(R.id.tab_radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.tab_home)
    RadioButton tab_home;
    @BindView(R.id.tab_subcribe)
    RadioButton tab_subcribe;
    @BindView(R.id.tab_zone)
    RadioButton tab_zone;
    @BindView(R.id.tab_mine)
    RadioButton tab_mine;


    @BindView(R.id.iv_news)
    ImageView iv_news;
    @BindView(R.id.iv_billboard)
    ImageView iv_billboard;
    @BindView(R.id.iv_hot)
    ImageView iv_hot;
    @BindView(R.id.iv_search)
    ImageView iv_search;

    private List<Fragment>fragmentList;
    private ViewPagerAdapter adapter;
    private List<RadioButton>radioButtonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }
    public void init(){
        fragmentList=new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new SubcribeFragment());
        fragmentList.add(new ZoneFragment());
        fragmentList.add(new MineFragment());
        radioButtonList=new ArrayList<>();
        radioButtonList.add(tab_home);
        radioButtonList.add(tab_subcribe);
        radioButtonList.add(tab_zone);
        radioButtonList.add(tab_mine);
        adapter=new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        initListener();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<radioButtonList.size();i++){
            radioButtonList.get(i).setChecked(i==position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.removeOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.tab_home :
                viewPager.setCurrentItem(0);
            break;
            case R.id.tab_subcribe:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab_choushoulu:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tab_zone:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab_mine:
                viewPager.setCurrentItem(3);
                break;

        }
    }


    public void initListener(){
        iv_news.setOnClickListener(this);
        iv_hot.setOnClickListener(this);
        iv_billboard.setOnClickListener(this);
        iv_search.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.iv_news:
                intent.setClass(this,NewsActivity.class);
                break;
            case R.id.iv_billboard:
                intent.setClass(this,BillboardActivity.class);
                break;
            case R.id.iv_hot:
                intent.setClass(this,HotActivity.class);
                break;
            case R.id.iv_search:
                intent.setClass(this,SearchActivity.class);
                break;
        }
        startActivity(intent);
    }
}
