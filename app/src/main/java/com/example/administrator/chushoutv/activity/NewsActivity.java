package com.example.administrator.chushoutv.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.chushoutv.R;
import com.example.administrator.chushoutv.constants.Urls;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.iv_layout_toolbar1)
    ImageView iv_back;
    @BindView(R.id.tv_layout_toolbar1)
    TextView tv_title;
    @BindView(R.id.rg_news)
    RadioGroup rg_news;
    @BindView(R.id.wv_layout_webview)
    WebView wv_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        tv_title.setText("触手资讯");
        iv_back.setOnClickListener(this);
        rg_news.setOnCheckedChangeListener(this);
    }





    //返回按钮的点击事件
    @Override
    public void onClick(View v) {
        finish();
    }
    //单选按钮的点击事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_news_one:
                getData(Urls.INFORMATION_GAME);
                break;
            case R.id.rb_news_two:
                getData(Urls.INFORMATION_NEWS);
                break;
        }
    }


    private void getData(String url) {

    }
}
