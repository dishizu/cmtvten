package com.example.administrator.chushoutv.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.tab_viewPager)
    ViewPager viewPager;
    @BindView(R.id.tab_radioGroup)
    RadioGroup radioGroup;
    private List<Fragment>fragmentList;
    private ViewPagerAdapter adapter;
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
        adapter=new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<radioGroup.getChildCount();i++){
            radioGroup.getChildAt(i).setSelected(i==position);
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
                break;
            case R.id.tab_zone:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab_mine:
                viewPager.setCurrentItem(3);
                break;

        }
    }
}
