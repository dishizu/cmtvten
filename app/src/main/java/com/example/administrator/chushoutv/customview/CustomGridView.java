package com.example.administrator.chushoutv.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/8/1.
 */
public class CustomGridView extends GridView{

    public CustomGridView(Context context) {
        super(context);
    }

    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //自己计算高度:MeasureSpec测量类
        //生成一个新的值
        //调用系统的测量方法，测量的高度只要不超过给出的最大值，在最大值的范围内有多大区域就显示多大
        int h = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, h);
    }
}
