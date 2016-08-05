package com.example.administrator.chushoutv.customview;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 自定义对话框
 */
public class CustomDialog extends ProgressDialog {

    Context context;

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }

}
